package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class Entregas {
	
	private int idEntrega;
	private int idPedido;
	private int idEstado;
	private String tipoEntrega;
	private String recibidoPor;
	private String evidenciaEntregaUrl;
	private String observacion;
	private Date fechaEntregaReal;
	
	public Entregas(int idEntrega, int idPedido, int idEstado, String tipoEntrega, String recibidoPor,
			String evidenciaEntregaUrl, String observacion, Date fechaEntregaReal) {
		super();
		this.idEntrega = idEntrega;
		this.idPedido = idPedido;
		this.idEstado = idEstado;
		this.tipoEntrega = tipoEntrega;
		this.recibidoPor = recibidoPor;
		this.evidenciaEntregaUrl = evidenciaEntregaUrl;
		this.observacion = observacion;
		this.fechaEntregaReal = fechaEntregaReal;
	}
	
	

	public Entregas() {
		super();
	}



	public int getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public String getRecibidoPor() {
		return recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

	public String getEvidenciaEntregaUrl() {
		return evidenciaEntregaUrl;
	}

	public void setEvidenciaEntregaUrl(String evidenciaEntregaUrl) {
		this.evidenciaEntregaUrl = evidenciaEntregaUrl;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaEntregaReal() {
		return fechaEntregaReal;
	}

	public void setFechaEntregaReal(Date fechaEntregaReal) {
		this.fechaEntregaReal = fechaEntregaReal;
	}
	
	

}
