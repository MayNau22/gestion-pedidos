package com.uisrael.pedidos2026.presentacion.dto.response;

import java.util.Date;
import java.util.List;

public class PedidosResponseDto {

	private int idPedido;
	private Date  fechaPedido;
	private Date fechaEntrega;
	private String direccionEntrega;
	private String observacion;
	private Double total;
	private int idEstado;
	private int idUsuario;
	private String nombreCliente;
	private String apellidoCliente;
	private String celularCliente;
	
	private String nombreEstado;
	private String tipoEstado;
	
	private List<DetallePedidosResponseDto> detalles;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<DetallePedidosResponseDto> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedidosResponseDto> detalles) {
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

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	
	
	
}
