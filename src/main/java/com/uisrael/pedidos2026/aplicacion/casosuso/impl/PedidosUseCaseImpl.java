package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;

public class PedidosUseCaseImpl implements IPedidosUseCase {
	private final IPedidosRepositorio repositorio;

	public PedidosUseCaseImpl(IPedidosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Pedidos guardar(Pedidos nuevopedidos) {
		
		return repositorio.guardar(nuevopedidos);
	}

	@Override
	public Pedidos buscarPorId(int idPedidos) {
		
		return repositorio.buscarPorId(idPedidos)
				.orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
	}

	@Override
	public List<Pedidos> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idPedidos) {
		repositorio.eliminar(idPedidos);
		
	}
	
	
	

}
