package com.uisrael.pedidos2026.dominio.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedidos {

	private int idPedido;
	private int idUsuario;
	private int idEstado;
	private String nombreCliente;
	private String celularCliente;
	private Date fechaPedido;
	private Date fechaEntrega;
	private String direccionEntrega;
	private String observacion;
	private Double total;

	private List<DetallePedidos> detalles = new ArrayList<>();

	public Pedidos() {
	}


	public Pedidos(int idPedido, int idUsuario, int idEstado, String nombreCliente, String celularCliente,
			Date fechaPedido, Date fechaEntrega, String direccionEntrega, String observacion, Double total,
			List<DetallePedidos> detalles) {
		super();
		this.idPedido = idPedido;
		this.idUsuario = idUsuario;
		this.idEstado = idEstado;
		this.nombreCliente = nombreCliente;
		this.celularCliente = celularCliente;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.direccionEntrega = direccionEntrega;
		this.observacion = observacion;
		this.total = total;
		this.detalles = detalles;
	}


	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {

		this.direccionEntrega = direccionEntrega;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {

		this.observacion = observacion;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<DetallePedidos> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedidos> detalles) {

		this.detalles = detalles;
	}
	
	public String getNombreCliente() {
	    return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
	    this.nombreCliente = nombreCliente;
	}

	public String getCelularCliente() {
	    return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
	    this.celularCliente = celularCliente;
	}
}