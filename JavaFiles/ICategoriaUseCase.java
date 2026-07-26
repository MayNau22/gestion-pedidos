package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;

public interface ICategoriaUseCase {
	
	Categoria guardar(Categoria nuevaCateogoria);
	Categoria buscarId(int idCategoria);
	List<Categoria> listarTodos();
	void eliminar(int idCategoria);

}
