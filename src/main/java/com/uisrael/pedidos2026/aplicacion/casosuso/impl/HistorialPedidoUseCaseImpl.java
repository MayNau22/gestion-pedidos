package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedido;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;

public class HistorialPedidoUseCaseImpl implements IHistorialPedidoUseCase {

	private final IHistorialPedidoRepositorio repositorio;

	public HistorialPedidoUseCaseImpl(IHistorialPedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public HistorialPedido guardar(HistorialPedido nuevoHistorial) {
		return repositorio.guardar(nuevoHistorial);
	}

	@Override
	public HistorialPedido buscarPorId(int idHistorial) {
		return repositorio.buscarPorId(idHistorial)
				.orElseThrow(() -> new RuntimeException("Historial de pedido no encontrado"));
	}

	@Override
	public List<HistorialPedido> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHistorial) {
		repositorio.eliminar(idHistorial);
	}
}