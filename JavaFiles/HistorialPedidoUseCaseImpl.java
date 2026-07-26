package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;

public class HistorialPedidoUseCaseImpl implements IHistorialPedidoUseCase {
	

	private final IHistorialPedidoRepositorio repositorio;


	public HistorialPedidoUseCaseImpl(IHistorialPedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public HistorialPedidos guardar(HistorialPedidos nuevoHistorialPedidos) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoHistorialPedidos);
	}

	@Override
	public HistorialPedidos buscarPorId(int idHistorialPedidos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idHistorialPedidos).orElseThrow(() -> new RuntimeException("historial de pedido no encontrado"));
	}

	@Override
	public List<HistorialPedidos> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHistorialPedidos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idHistorialPedidos);
		
	}

}
