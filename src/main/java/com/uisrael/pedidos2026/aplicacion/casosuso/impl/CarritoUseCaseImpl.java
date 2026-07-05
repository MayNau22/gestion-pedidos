package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICarritoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;

public class CarritoUseCaseImpl implements ICarritoUseCase{
	
	private final ICarritoRepositorio repositorio;
	
	public CarritoUseCaseImpl(ICarritoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Carrito guardar(Carrito nuevoCarrito) {
		return repositorio.guardar(nuevoCarrito);
	}

	@Override
	public Carrito buscarId(int idCarrito) {
		return repositorio.buscarId(idCarrito).orElseThrow(
				() -> new RuntimeException("Carrito no encontrado"));
	}

	@Override
	public List<Carrito> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCarrito) {
		repositorio.eliminar(idCarrito);
	}

}
