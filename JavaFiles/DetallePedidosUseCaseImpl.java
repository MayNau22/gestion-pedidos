package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetallePedidosUseCase;
import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IDetallePedidosRepositorio;

public class DetallePedidosUseCaseImpl implements IDetallePedidosUseCase {

	private final IDetallePedidosRepositorio repositorio;

	public DetallePedidosUseCaseImpl(IDetallePedidosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public DetallePedidos guardar(DetallePedidos nuevoDestallePedidos) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoDestallePedidos);
	}

	@Override
	public DetallePedidos buscarPorId(int idDestallePedidos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDestallePedidos).orElseThrow(() -> new RuntimeException("grupo no encontrado"));
	}

	@Override
	public List<DetallePedidos> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDestallePedidos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDestallePedidos);
		
	}



}
