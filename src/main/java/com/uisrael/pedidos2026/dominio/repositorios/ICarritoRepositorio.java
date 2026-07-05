package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;

public interface ICarritoRepositorio {
	
	Carrito guardar(Carrito nuevoCarrito);
	Optional<Carrito> buscarId(int idCarrito);
	List<Carrito> listarTodos();
	void eliminar(int idCarrito);
	

}
