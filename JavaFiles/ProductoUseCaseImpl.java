package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase{
	
	private final IProductoRepositorio repositorio;
	
	
	public ProductoUseCaseImpl(IProductoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		return repositorio.guardar(nuevoProducto);
	}

	@Override
	public Producto buscarId(int idProducto) {
		return repositorio.buscarId(idProducto).orElseThrow(
				() -> new RuntimeException("Producto no encontrado"));
	}

	@Override
	public List<Producto> listarProductos() {
		return repositorio.listarProductos();
	}

	@Override
	public void eliminar(int idProducto) {
		repositorio.eliminar(idProducto);
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}

}
