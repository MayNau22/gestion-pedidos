package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;

public class EntregasUseCaseImpl implements IEntregasUseCase {

	private final IEntregasRepositorio repositorio;

	public EntregasUseCaseImpl(IEntregasRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Entregas guardar(Entregas nuevaEntrega) {
		return repositorio.guardar(nuevaEntrega);
	}

	@Override
	public Entregas buscarPorId(int idEntrega) {
		return repositorio.buscarPorId(idEntrega)
				.orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
	}

	@Override
	public List<Entregas> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEntrega) {
		repositorio.eliminar(idEntrega);
	}
}