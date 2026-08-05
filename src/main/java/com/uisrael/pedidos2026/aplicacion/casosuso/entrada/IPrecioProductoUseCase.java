package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.PrecioProducto;

public interface IPrecioProductoUseCase {
	PrecioProducto registrarPrecio(int idProducto, Double nuevoPrecio);

	PrecioProducto obtenerPrecioActivo(int idProducto);

	List<PrecioProducto> listarHistorial(int idProducto);
}
