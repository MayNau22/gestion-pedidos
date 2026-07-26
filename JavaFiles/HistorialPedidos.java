package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class HistorialPedidos {

	private int idHistorial;
	private int idPedido;
	private int idEstadoAnterior;
	private int idEstadoNuevo;
	private String observacion;
	private Date fecha;
	private int usuarioModifica;
	
	
	public HistorialPedidos(int idHistorial, int idPedido, int idEstadoAnterior, int idEstadoNuevo, String observacion,
			Date fecha, int usuarioModifica) {
		super();
		this.idHistorial = idHistorial;
		this.idPedido = idPedido;
		this.idEstadoAnterior = idEstadoAnterior;
		this.idEstadoNuevo = idEstadoNuevo;
		this.observacion = observacion;
		this.fecha = fecha;
		this.usuarioModifica = usuarioModifica;
	}
	
	


	public HistorialPedidos() {
		super();
	}


	public int getIdHistorial() {
		return idHistorial;
	}


	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getIdEstadoAnterior() {
		return idEstadoAnterior;
	}


	public void setIdEstadoAnterior(int idEstadoAnterior) {
		this.idEstadoAnterior = idEstadoAnterior;
	}


	public int getIdEstadoNuevo() {
		return idEstadoNuevo;
	}


	public void setIdEstadoNuevo(int idEstadoNuevo) {
		this.idEstadoNuevo = idEstadoNuevo;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getUsuarioModifica() {
		return usuarioModifica;
	}


	public void setUsuarioModifica(int usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	
	
	
	
}