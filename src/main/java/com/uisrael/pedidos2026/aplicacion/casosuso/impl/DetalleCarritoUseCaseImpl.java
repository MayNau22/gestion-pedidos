package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetalleCarritoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;
import com.uisrael.pedidos2026.dominio.repositorios.IDetalleCarritoRepositorio;

public class DetalleCarritoUseCaseImpl implements IDetalleCarritoUseCase{

	private final IDetalleCarritoRepositorio repositorio;
		
	public DetalleCarritoUseCaseImpl(IDetalleCarritoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public DetalleCarrito guardar(DetalleCarrito nuevoDetalleCarrito) {
		return repositorio.guardar(nuevoDetalleCarrito);
	}

	@Override
	public DetalleCarrito buscarId(int idDetalleCarrito) {
		return repositorio.buscarId(idDetalleCarrito).orElseThrow(
				() -> new RuntimeException("Carrito no encontrado"));
	}

	@Override
	public List<DetalleCarrito> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDetalleCarrito) {
		repositorio.eliminar(idDetalleCarrito);
	}

}
