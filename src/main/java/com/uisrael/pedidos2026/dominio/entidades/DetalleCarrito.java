package com.uisrael.pedidos2026.dominio.entidades;

public class DetalleCarrito {
	
	private int idDetalleCarrito;
	private int idCarrito;
	private int idProducto;
	private double subtotal;
	
	
	public DetalleCarrito(int idDetalleCarrito, int idCarrito, int idProducto, double subtotal) {
		super();
		this.idDetalleCarrito = idDetalleCarrito;
		this.idCarrito = idCarrito;
		this.idProducto = idProducto;
		this.subtotal = subtotal;
	}


	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}


	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}


	public int getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	

	

}
