package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class RecuperacionPassword {
	
	private Integer idRecuperacion;
    private Usuario usuario;
    private String token;
    private Date fechaCreacion;
    private Date fechaExpiracion;
    private boolean utilizado;
    
    
    
	public RecuperacionPassword() {
		super();
	}

	public RecuperacionPassword(Integer idRecuperacion, Usuario usuario, String token, Date fechaCreacion,
			Date fechaExpiracion, boolean utilizado) {
		super();
		this.idRecuperacion = idRecuperacion;
		this.usuario = usuario;
		this.token = token;
		this.fechaCreacion = fechaCreacion;
		this.fechaExpiracion = fechaExpiracion;
		this.utilizado = utilizado;
	}

	public Integer getIdRecuperacion() {
		return idRecuperacion;
	}

	public void setIdRecuperacion(Integer idRecuperacion) {
		this.idRecuperacion = idRecuperacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public boolean isUtilizado() {
		return utilizado;
	}

	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}
	
    
    

}
