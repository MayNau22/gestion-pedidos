package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;

public interface ICategoriaRepositorio {
	
	Categoria guardar(Categoria nuevaCateogoria);
	Optional<Categoria> buscarId(int idCategoria);
	List<Categoria> listarTodos();
	void eliminar(int idCategoria);
	void activar(int idCategoria);
	Categoria actualizar(Categoria categoria);

}
