package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;

public class ComprobantesPagoUseCaseImpl implements IComprobantesPagoUseCase {

	private final IComprobantesPagoRepositorio repositorio;

	public ComprobantesPagoUseCaseImpl(IComprobantesPagoRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public ComprobantesPago guardar(ComprobantesPago nuevoComprobante) {

		return repositorio.guardar(nuevoComprobante);
	}

	@Override
	public ComprobantesPago buscarPorId(int idComprobante) {

		return repositorio.buscarPorId(idComprobante)
				.orElseThrow(() -> new RuntimeException("Comprobante de pago no encontrado"));
	}

	@Override
	public Optional<ComprobantesPago> buscarPorPedido(int idPedido) {

		if (idPedido <= 0) {

			throw new RuntimeException("El pedido es obligatorio");
		}

		return repositorio.buscarPorPedido(idPedido);
	}

	@Override
	public ComprobantesPago guardarArchivo(int idPedido, MultipartFile archivo, String tipoPago, Double monto,
			String observacion) {

		if (idPedido <= 0) {

			throw new RuntimeException("El pedido es obligatorio");
		}

		if (archivo == null || archivo.isEmpty()) {

			throw new RuntimeException("Seleccione una imagen");
		}

		if (monto == null || monto <= 0) {

			throw new RuntimeException("Ingrese un monto válido");
		}

		String tipoContenido = archivo.getContentType();

		boolean permitido = "image/jpeg".equalsIgnoreCase(tipoContenido) || "image/png".equalsIgnoreCase(tipoContenido)
				|| "image/webp".equalsIgnoreCase(tipoContenido);

		if (!permitido) {

			throw new RuntimeException("Solo se permiten imágenes JPG, PNG o WEBP");
		}

		long limite = 5L * 1024L * 1024L;

		if (archivo.getSize() > limite) {

			throw new RuntimeException("La imagen no puede superar los 5 MB");
		}

		return repositorio.guardarArchivo(idPedido, archivo, tipoPago, monto, observacion);
	}

	@Override
	public List<ComprobantesPago> listarTodos() {

		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idComprobante) {

		repositorio.eliminar(idComprobante);
	}
}