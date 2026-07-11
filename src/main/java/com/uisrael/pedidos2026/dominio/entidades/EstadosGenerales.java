package com.uisrael.pedidos2026.dominio.entidades;



public class EstadosGenerales {
	
	private int  idEstado;
	private String tipoEstado;
	private String nombre;
	private String descripcion;
	private String activo;
	
	public EstadosGenerales(int idEstado, String tipoEstado, String nombre, String descripcion, String activo) {
		super();
		this.idEstado = idEstado;
		this.tipoEstado = tipoEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	

	public EstadosGenerales() {
		super();
	}



	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	

}
