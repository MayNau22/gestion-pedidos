package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class Carrito {

	private int idCarrito;
	private int idUsuario;
	private Date fechaCreacion;
	
	public Carrito(int idCarrito, int idUsuario, Date fechaCreacion) {
		super();
		this.idCarrito = idCarrito;
		this.idUsuario = idUsuario;
		this.fechaCreacion = fechaCreacion;
	}

	public Carrito() {
		super();
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}