package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;

public class PedidosUseCaseImpl implements IPedidosUseCase{

	private final IPedidosRepositorio repositorio;

	public PedidosUseCaseImpl(IPedidosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Pedidos guardar(Pedidos nuevopedido) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevopedido);
	}

	@Override
	public Pedidos buscarPorId(int idPedidos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idPedidos)
				.orElseThrow(() -> new RuntimeException("pedido no encontrado"));
	}

	@Override
	public List<Pedidos> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idPedidos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idPedidos);
		
	}

}
