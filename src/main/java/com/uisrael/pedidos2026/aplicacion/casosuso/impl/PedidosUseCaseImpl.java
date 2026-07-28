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
	public Pedidos guardar(Pedidos nuevopedido) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevopedido);
	}

	@Override
	public Pedidos buscarPorId(int idPedidos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idPedidos).orElseThrow(() -> new RuntimeException("pedido no encontrado"));
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

	@Override
	public List<Pedidos> listarPorUsuario(int idUsuario) {

		if (idUsuario <= 0) {
			throw new RuntimeException("El usuario es obligatorio");
		}

		return repositorio.listarPorUsuario(idUsuario);
	}

	@Override
	public Pedidos cambiarEstado(int idPedido, int idEstado, int idUsuario, String observacion) {

		if (idPedido <= 0) {

			throw new RuntimeException("El pedido es obligatorio");
		}

		if (idEstado <= 0) {

			throw new RuntimeException("El estado es obligatorio");
		}

		if (idUsuario <= 0) {

			throw new RuntimeException("El usuario que modifica es obligatorio");
		}

		if (observacion == null || observacion.isBlank()) {

			throw new RuntimeException("Debe indicar el motivo del cambio");
		}

		return repositorio.cambiarEstado(idPedido, idEstado, idUsuario, observacion.trim());
	}

}
