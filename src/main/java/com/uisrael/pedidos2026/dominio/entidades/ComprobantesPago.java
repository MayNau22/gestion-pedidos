package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class ComprobantesPago {
	
	private int idComprobante;
	private int idPedido;
	private String tipoPago;
	private String archivoUrl;
	private Double monto;
	private Date fechaSubida;
	private int idEstado;
	private String observacion;
	
	public ComprobantesPago(int idComprobante, int idPedido, String tipoPago, String archivoUrl, Double monto,
			Date fechaSubida, int idEstado, String observacion) {
		super();
		this.idComprobante = idComprobante;
		this.idPedido = idPedido;
		this.tipoPago = tipoPago;
		this.archivoUrl = archivoUrl;
		this.monto = monto;
		this.fechaSubida = fechaSubida;
		this.idEstado = idEstado;
		this.observacion = observacion;
	}

	public int getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getArchivoUrl() {
		return archivoUrl;
	}

	public void setArchivoUrl(String archivoUrl) {
		this.archivoUrl = archivoUrl;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
	

}
