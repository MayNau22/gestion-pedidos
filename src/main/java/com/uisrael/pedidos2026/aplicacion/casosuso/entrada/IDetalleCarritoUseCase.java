package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;

public interface IDetalleCarritoUseCase {
	DetalleCarrito guardar(DetalleCarrito nuevoDetalleCarrito);
	DetalleCarrito buscarId(int idDetalleCarrito);
	List<DetalleCarrito> listarTodos();
	void eliminar(int idDetalleCarrito);
}
