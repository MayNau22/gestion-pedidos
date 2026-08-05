package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IEntregasJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IComprobantesPagoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEntregasJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEstadosGeneralesJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorios;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EntregasRepositorioImpl implements IEntregasRepositorio {

	private static final List<Integer> ESTADOS_ACTIVOS = List.of(13, 14, 15, 18);

	private final IEntregasJpaRepositorio jpaRepositorio;
	private final IEntregasJpaMapper mapper;
	private final IEstadosGeneralesJpaRepositorio estadosJpaRepositorio;
	private final IComprobantesPagoJpaRepositorio comprobantesJpaRepositorio;
	private final IPedidosJpaRepositorios pedidosJpaRepositorio;

	public EntregasRepositorioImpl(IEntregasJpaRepositorio jpaRepositorio, IEntregasJpaMapper mapper,
			IEstadosGeneralesJpaRepositorio estadosJpaRepositorio,
			IComprobantesPagoJpaRepositorio comprobantesJpaRepositorio, IPedidosJpaRepositorios pedidosJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.mapper = mapper;
		this.estadosJpaRepositorio = estadosJpaRepositorio;
		this.comprobantesJpaRepositorio = comprobantesJpaRepositorio;
		this.pedidosJpaRepositorio = pedidosJpaRepositorio;
	}

	@Override
	public Entregas guardar(Entregas nuevaEntrega) {

		EntregasEntity entity = mapper.toEntity(nuevaEntrega);

		EntregasEntity guardada = jpaRepositorio.save(entity);

		return convertirADominio(guardada);
	}

	@Override
	public Optional<Entregas> buscarPorId(int idEntrega) {

		return jpaRepositorio.findById(idEntrega).map(this::convertirADominio);
	}

	@Override
	public Optional<Entregas> buscarPorPedido(int idPedido) {

		return jpaRepositorio.findByPedidoEntregaIdPedido(idPedido).map(this::convertirADominio);
	}

	@Override
	public List<Entregas> listarTodos() {

		return jpaRepositorio.findAll().stream().map(this::convertirADominio).toList();
	}

	@Override
	public List<Entregas> listarActivas() {

		return jpaRepositorio.findByEstadoEntregaIdEstadoInOrderByPedidoEntregaFechaEntregaAsc(ESTADOS_ACTIVOS).stream()
				.map(this::convertirADominio).toList();
	}

	@Override
	public boolean existePorPedido(int idPedido) {

		return jpaRepositorio.existsByPedidoEntregaIdPedido(idPedido);
	}

	@Override
	public void eliminar(int idEntrega) {

		jpaRepositorio.deleteById(idEntrega);
	}

	private Entregas convertirADominio(EntregasEntity entity) {

		Entregas entrega = new Entregas();

		entrega.setIdEntrega(entity.getIdEntrega());
		entrega.setTipoEntrega(entity.getTipoEntrega());
		entrega.setRecibidoPor(entity.getRecibidoPor());
		entrega.setEvidenciaEntregaUrl(entity.getEvidenciaEntregaUrl());
		entrega.setObservacion(entity.getObservacion());
		entrega.setFechaEntregaReal(entity.getFechaEntregaReal());

		if (entity.getEstadoEntrega() != null) {

			entrega.setIdEstado(entity.getEstadoEntrega().getIdEstado());

			entrega.setNombreEstado(entity.getEstadoEntrega().getNombre());
		}

		if (entity.getPedidoEntrega() != null) {

			entrega.setIdPedido(entity.getPedidoEntrega().getIdPedido());

			entrega.setDireccionEntrega(entity.getPedidoEntrega().getDireccionEntrega());

			entrega.setFechaPedido(entity.getPedidoEntrega().getFechaPedido());

			entrega.setFechaEntregaSolicitada(entity.getPedidoEntrega().getFechaEntrega());

			entrega.setTotalPedido(entity.getPedidoEntrega().getTotal());

			if (entity.getPedidoEntrega().getUsuarioPedido() != null) {

				entrega.setNombreCliente(entity.getPedidoEntrega().getUsuarioPedido().getNombre());

				entrega.setApellidoCliente(entity.getPedidoEntrega().getUsuarioPedido().getApellido());

				entrega.setCelularCliente(entity.getPedidoEntrega().getUsuarioPedido().getCelular());

				entrega.setCorreoCliente(entity.getPedidoEntrega().getUsuarioPedido().getCorreo());
			}

			if (entity.getPedidoEntrega().getDetallePedido() != null) {

				List<DetallePedidos> detalles = entity.getPedidoEntrega().getDetallePedido().stream()
						.map(this::convertirDetalle).toList();

				entrega.setDetalles(detalles);
			}
		}

		return entrega;
	}

	private DetallePedidos convertirDetalle(DetallePedidoEntity entity) {

		DetallePedidos detalle = new DetallePedidos();

		detalle.setIdDetallePedido(entity.getIdDetallePedido());

		if (entity.getPedido() != null) {

			detalle.setIdPedido(entity.getPedido().getIdPedido());
		}

		if (entity.getProducto() != null) {

			detalle.setIdProducto(entity.getProducto().getIdProducto());

			detalle.setNombreProducto(entity.getProducto().getNombre());

			detalle.setImagenUrl(entity.getProducto().getImagenUrl());
		}

		detalle.setCantidad(entity.getCantidad());
		detalle.setPrecioUnitario(entity.getPrecioUnitario());
		detalle.setSubtotal(entity.getSubtotal());

		return detalle;
	}

	@Override
	@Transactional
	public Entregas cambiarEstado(int idEntrega, int idEstado, String observacion) {

		EntregasEntity entrega = jpaRepositorio.findById(idEntrega)
				.orElseThrow(() -> new RuntimeException("Entrega no encontrada"));

		EstadosGeneralesEntity nuevoEstado = estadosJpaRepositorio.findById(idEstado)
				.orElseThrow(() -> new RuntimeException("Estado no encontrado"));

		String tipoEstado = nuevoEstado.getTipoEstado() != null ? nuevoEstado.getTipoEstado().trim() : "";

		if (!"ENTREGA".equalsIgnoreCase(tipoEstado)) {

			throw new RuntimeException("El estado seleccionado no pertenece al módulo ENTREGA");
		}

		entrega.setEstadoEntrega(nuevoEstado);

		if (observacion != null && !observacion.isBlank()) {

			entrega.setObservacion(observacion.trim());
		}

		EntregasEntity actualizada = jpaRepositorio.save(entrega);

		return convertirADominio(actualizada);
	}

	@Override
	@Transactional
	public Entregas finalizarEntrega(int idEntrega, MultipartFile evidencia, String recibidoPor, String observacion) {

		try {

			EntregasEntity entrega = jpaRepositorio.findById(idEntrega)
					.orElseThrow(() -> new RuntimeException("Entrega no encontrada"));

			PedidosEntity pedido = entrega.getPedidoEntrega();

			if (pedido == null) {

				throw new RuntimeException("La entrega no tiene un pedido asociado");
			}

			if (entrega.getEstadoEntrega() != null
					&& "ENTREGADA".equalsIgnoreCase(entrega.getEstadoEntrega().getNombre())) {

				throw new RuntimeException("La entrega ya está finalizada");
			}

			List<ComprobantesPagoEntity> comprobantes = comprobantesJpaRepositorio
					.findByPedidoComprobanteIdPedidoOrderByFechaSubidaDesc(pedido.getIdPedido());

			double totalAprobado = comprobantes.stream().filter(c -> c.getEstadoComprobante() != null)
					.filter(c -> "APROBADO".equalsIgnoreCase(c.getEstadoComprobante().getNombre()))
					.filter(c -> c.getMonto() != null).mapToDouble(ComprobantesPagoEntity::getMonto).sum();

			double saldoPendiente = Math.max(pedido.getTotal() - totalAprobado, 0.0);

			if (saldoPendiente > 0.001) {

				throw new RuntimeException("No se puede finalizar la entrega. " + "Existe un saldo pendiente de $"
						+ String.format("%.2f", saldoPendiente));
			}

			EstadosGeneralesEntity estadoEntregada = estadosJpaRepositorio
					.findByNombreIgnoreCaseAndTipoEstadoIgnoreCase("ENTREGADA", "ENTREGA")
					.orElseThrow(() -> new RuntimeException("No existe el estado ENTREGADA / ENTREGA"));

			EstadosGeneralesEntity estadoPedidoFinalizado = estadosJpaRepositorio
					.findByNombreIgnoreCaseAndTipoEstadoIgnoreCase("FINALIZADO", "PEDIDO")
					.orElseThrow(() -> new RuntimeException("No existe el estado FINALIZADO / PEDIDO"));

			Path carpeta = Paths.get("C:/pedidosweb/imagenes/entregas");

			Files.createDirectories(carpeta);

			String nombreArchivo = UUID.randomUUID() + "_" + evidencia.getOriginalFilename();

			Path destino = carpeta.resolve(nombreArchivo);

			Files.copy(evidencia.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

			entrega.setEvidenciaEntregaUrl("/evidencias-entrega/" + nombreArchivo);

			entrega.setRecibidoPor(recibidoPor);

			entrega.setObservacion(observacion);

			entrega.setFechaEntregaReal(new Date());

			entrega.setEstadoEntrega(estadoEntregada);

			pedido.setEstadoPedido(estadoPedidoFinalizado);

			pedidosJpaRepositorio.save(pedido);

			EntregasEntity guardada = jpaRepositorio.save(entrega);

			return convertirADominio(guardada);

		} catch (RuntimeException e) {

			throw e;

		} catch (Exception e) {

			throw new RuntimeException("Error al finalizar la entrega", e);
		}
	}
}