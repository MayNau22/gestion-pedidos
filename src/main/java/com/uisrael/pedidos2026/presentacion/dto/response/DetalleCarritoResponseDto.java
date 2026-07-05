package com.uisrael.pedidos2026.presentacion.dto.response;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.dominio.entidades.Producto;

public class DetalleCarritoResponseDto {

	private int idDetalleCarrito;
	private Carrito idCarrito;
	private Producto idProducto;
	private double subtotal;
	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}
	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}
	public Carrito getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Carrito idCarrito) {
		this.idCarrito = idCarrito;
	}
	public Producto getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
