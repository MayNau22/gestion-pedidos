package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Producto;


public interface IProductoRepositorio {
	
	Producto guardar(Producto nuevoProducto);
	Optional<Producto> buscarId(int idProducto);
	List<Producto> listarProductos();
	void eliminar(int idProducto);
	List<Producto> findByNombre(String nombre);
}
