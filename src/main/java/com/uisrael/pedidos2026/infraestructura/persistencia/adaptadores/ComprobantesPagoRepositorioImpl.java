package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IComprobantesPagoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IComprobantesPagoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEstadosGeneralesJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorios;

import org.springframework.transaction.annotation.Transactional;

@Repository
public class ComprobantesPagoRepositorioImpl implements IComprobantesPagoRepositorio {

	private final IComprobantesPagoJpaRepositorio jpaRepositorio;
	private final IComprobantesPagoJpaMapper entityMapper;
	private final IPedidosJpaRepositorios pedidosJpaRepositorio;
	private final IEstadosGeneralesJpaRepositorio estadosJpaRepositorio;

	public ComprobantesPagoRepositorioImpl(IComprobantesPagoJpaRepositorio jpaRepositorio,
			IComprobantesPagoJpaMapper entityMapper, IPedidosJpaRepositorios pedidosJpaRepositorio,
			IEstadosGeneralesJpaRepositorio estadosJpaRepositorio) {

		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.pedidosJpaRepositorio = pedidosJpaRepositorio;
		this.estadosJpaRepositorio = estadosJpaRepositorio;
	}

	@Override
	public ComprobantesPago guardar(ComprobantesPago nuevoComprobante) {

		ComprobantesPagoEntity entity = entityMapper.toEntity(nuevoComprobante);

		ComprobantesPagoEntity guardado = jpaRepositorio.save(entity);

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ComprobantesPago> buscarPorId(int idComprobante) {

		return jpaRepositorio.findById(idComprobante).map(entityMapper::toDomain);
	}

	@Override
	public List<ComprobantesPago> listarTodos() {

		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idComprobante) {

		jpaRepositorio.deleteById(idComprobante);
	}

	@Override
	public Optional<ComprobantesPago> buscarPorPedido(int idPedido) {

		return jpaRepositorio.findFirstByPedidoComprobanteIdPedidoOrderByFechaSubidaDesc(idPedido)
				.map(entityMapper::toDomain);
	}

	@Override
	public ComprobantesPago guardarArchivo(int idPedido, MultipartFile archivo, String tipoPago, Double monto,
			String observacion) {

		if (archivo == null || archivo.isEmpty()) {
			throw new RuntimeException("Debe seleccionar una imagen");
		}

		if (monto == null || monto <= 0) {
			throw new RuntimeException("El monto debe ser mayor que cero");
		}

		try {

			PedidosEntity pedido = pedidosJpaRepositorio.findById(idPedido)
					.orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + idPedido));

			EstadosGeneralesEntity estado = estadosJpaRepositorio
					.findByNombreIgnoreCaseAndTipoEstadoIgnoreCase("PENDIENTE", "COMPROBANTE")
					.orElseThrow(() -> new RuntimeException("No existe el estado PENDIENTE " + "para COMPROBANTE"));

			Path carpeta = Paths.get("C:", "pedidosweb", "imagenes", "pagos").toAbsolutePath().normalize();

			Files.createDirectories(carpeta);

			String nombreOriginal = archivo.getOriginalFilename();

			String nombreSeguro = nombreOriginal != null && !nombreOriginal.isBlank()
					? nombreOriginal.replaceAll("[^a-zA-Z0-9._-]", "_")
					: "comprobante.jpg";

			String nombreArchivo = UUID.randomUUID() + "_" + nombreSeguro;

			Path destino = carpeta.resolve(nombreArchivo);

			Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

			ComprobantesPagoEntity entity = new ComprobantesPagoEntity();

			entity.setPedidoComprobante(pedido);
			entity.setTipoPago(tipoPago);
			entity.setMonto(monto);
			entity.setFechaSubida(new Date());
			entity.setEstadoComprobante(estado);
			entity.setObservacion(observacion);

			entity.setArchivoUrl("/comprobantes/" + nombreArchivo);

			ComprobantesPagoEntity guardado = jpaRepositorio.save(entity);

			return entityMapper.toDomain(guardado);

		} catch (Exception e) {

			throw new RuntimeException("Error al guardar comprobante: " + e.getMessage(), e);
		}
	}

	@Override
	public List<ComprobantesPago> listarPorPedido(int idPedido) {

		return jpaRepositorio.findByPedidoComprobanteIdPedidoOrderByFechaSubidaDesc(idPedido).stream()
				.map(entityMapper::toDomain).toList();
	}

	@Override
	@Transactional
	public ComprobantesPago cambiarEstado(int idComprobante, int idEstado, String observacion) {

		ComprobantesPagoEntity comprobante = jpaRepositorio.findById(idComprobante)
				.orElseThrow(() -> new RuntimeException("Comprobante no encontrado"));

		EstadosGeneralesEntity estado = estadosJpaRepositorio.findById(idEstado)
				.orElseThrow(() -> new RuntimeException("Estado no encontrado"));

		if (!"COMPROBANTE".equalsIgnoreCase(estado.getTipoEstado())) {

			throw new RuntimeException("El estado seleccionado no corresponde a COMPROBANTE");
		}

		comprobante.setEstadoComprobante(estado);

		if (observacion != null && !observacion.isBlank()) {

			comprobante.setObservacion(observacion.trim());
		}

		ComprobantesPagoEntity actualizado = jpaRepositorio.save(comprobante);

		return entityMapper.toDomain(actualizado);
	}
}