package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;


import com.uisrael.pedidos2026.dominio.entidades.Producto;

public interface IProductoUseCase {
	
	Producto guardar(Producto nuevoProducto);
	Producto buscarId(int idProducto);
	List<Producto> listarProductos();
	void eliminar(int idProducto);
	List<Producto> findByNombre(String nombre);
}
