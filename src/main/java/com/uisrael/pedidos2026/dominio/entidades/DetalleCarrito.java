package com.uisrael.pedidos2026.dominio.entidades;


public class DetalleCarrito {
	
	private int idDetalleCarrito;
	private Carrito carrito;
	private Producto producto;
	private int cantidad;
	private double subtotal;
		
	public DetalleCarrito(int idDetalleCarrito, Carrito carrito, Producto producto, int cantidad, double subtotal) {
		super();
		this.idDetalleCarrito = idDetalleCarrito;
		this.carrito = carrito;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}

	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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
