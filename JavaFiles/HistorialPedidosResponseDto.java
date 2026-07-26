package com.uisrael.pedidos2026.presentacion.dto.response;

import java.util.Date;

public class HistorialPedidosResponseDto {
	private int idHistorial;
	private int idEstadoAnterior;
	private int idEstadoNuevo;
	private String observacion;
	private Date fecha;
	private int usuarioModifica;
	private int idPedido;
	private int idUsuario;
	public int getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
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
	
	
	
}
