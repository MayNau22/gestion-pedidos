package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;

public interface IDetalleCarritoRepositorio {
	
	DetalleCarrito guardar(DetalleCarrito nuevoDetalleCarrito);
	Optional<DetalleCarrito> buscarId(int idDetalleCarrito);
	List<DetalleCarrito> listarTodos();
	void eliminar(int idDetalleCarrito);
}
