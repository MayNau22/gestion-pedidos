package com.uisrael.pedidos2026.presentacion.dto.response;



public class DetalleCarritoResponseDto {

	private int idDetalleCarrito;
	private int carrito;
	private int producto;
	private int cantidad;
	private double subtotal;
	
	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}
	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}
	public int getCarrito() {
		return carrito;
	}
	public void setCarrito(int carrito) {
		this.carrito = carrito;
	}
	public int getProducto() {
		return producto;
	}
	public void setProducto(int producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
