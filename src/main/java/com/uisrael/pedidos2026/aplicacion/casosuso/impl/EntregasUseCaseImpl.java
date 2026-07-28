package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;

public class EntregasUseCaseImpl implements IEntregasUseCase {

	private final IEntregasRepositorio repositorio;

	public EntregasUseCaseImpl(IEntregasRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public Entregas guardar(Entregas nuevaEntrega) {

		if (nuevaEntrega == null) {

			throw new RuntimeException("La entrega es obligatoria");
		}

		return repositorio.guardar(nuevaEntrega);
	}

	@Override
	public Entregas buscarPorId(int idEntrega) {

		return repositorio.buscarPorId(idEntrega).orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
	}

	@Override
	public Entregas buscarPorPedido(int idPedido) {

		return repositorio.buscarPorPedido(idPedido)
				.orElseThrow(() -> new RuntimeException("No existe una entrega para el pedido"));
	}

	@Override
	public List<Entregas> listarTodos() {

		return repositorio.listarTodos();
	}

	@Override
	public List<Entregas> listarActivas() {

		return repositorio.listarActivas();
	}

	@Override
	public void eliminar(int idEntrega) {

		repositorio.eliminar(idEntrega);
	}

	@Override
	public Entregas cambiarEstado(int idEntrega, int idEstado, String observacion) {

		if (idEntrega <= 0) {

			throw new RuntimeException("El identificador de la entrega es obligatorio");
		}

		if (idEstado <= 0) {

			throw new RuntimeException("El estado es obligatorio");
		}

		return repositorio.cambiarEstado(idEntrega, idEstado, observacion);
	}

	@Override
	public Entregas finalizarEntrega(int idEntrega, MultipartFile evidencia, String recibidoPor, String observacion) {

		if (idEntrega <= 0) {
			throw new RuntimeException("La entrega es obligatoria");
		}

		if (evidencia == null || evidencia.isEmpty()) {

			throw new RuntimeException("Debe adjuntar evidencia de entrega");
		}

		if (recibidoPor == null || recibidoPor.isBlank()) {

			throw new RuntimeException("Debe indicar quién recibió la entrega");
		}

		return repositorio.finalizarEntrega(idEntrega, evidencia, recibidoPor.trim(),
				observacion != null ? observacion.trim() : null);
	}
}