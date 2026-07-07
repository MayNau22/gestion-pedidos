package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.dominio.repositorios.ICategoriaRepositorio;

public class CategoriaUseCaseImpl implements ICategoriaUseCase{
	
	private final ICategoriaRepositorio repositorio;
	
	public CategoriaUseCaseImpl(ICategoriaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Categoria guardar(Categoria nuevaCateogoria) {
		return repositorio.guardar(nuevaCateogoria);
	}

	@Override
	public Categoria buscarId(int idCategoria) {
		return repositorio.buscarId(idCategoria).orElseThrow(
				() -> new RuntimeException("Categoria no encontrada"));
	}

	@Override
	public List<Categoria> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCategoria) {
		repositorio.eliminar(idCategoria);
		
	}

}
