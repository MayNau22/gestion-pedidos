package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetallePedidoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.DetallePedido;
import com.uisrael.pedidos2026.dominio.repositorios.IDetallePedidosRepositorio;

public class DetallePedidoUseCaseImpl implements IDetallePedidoUseCase {
	
	private final IDetallePedidosRepositorio repositorio;

	public DetallePedidoUseCaseImpl(IDetallePedidosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public DetallePedido guardar(DetallePedido nuevoDetallePedido) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoDetallePedido);
	}

	@Override
	public DetallePedido buscarPorId(int idDetallePedido) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDetallePedido)
				.orElseThrow(() -> new RuntimeException("Detalle de Pedido no encontrado"));
	}

	@Override
	public List<DetallePedido> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDetallePedido) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDetallePedido);
	}

	

}
