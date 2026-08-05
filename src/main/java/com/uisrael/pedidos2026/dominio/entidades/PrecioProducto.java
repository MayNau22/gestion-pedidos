package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;

public class PrecioProducto {
	
	 private int idPrecio;
	    private int idProducto;
	    private String nombreProducto;
	    private Double precio;
	    private Date fechaInicio;
	    private Date fechaFin;
	    private boolean activo;

	    public PrecioProducto() {
	    }

	    public PrecioProducto(
	            int idPrecio,
	            int idProducto,
	            String nombreProducto,
	            Double precio,
	            Date fechaInicio,
	            Date fechaFin,
	            boolean activo) {

	        this.idPrecio = idPrecio;
	        this.idProducto = idProducto;
	        this.nombreProducto = nombreProducto;
	        this.precio = precio;
	        this.fechaInicio = fechaInicio;
	        this.fechaFin = fechaFin;
	        this.activo = activo;
	    }

	    public int getIdPrecio() {
	        return idPrecio;
	    }

	    public void setIdPrecio(int idPrecio) {
	        this.idPrecio = idPrecio;
	    }

	    public int getIdProducto() {
	        return idProducto;
	    }

	    public void setIdProducto(int idProducto) {
	        this.idProducto = idProducto;
	    }

	    public String getNombreProducto() {
	        return nombreProducto;
	    }

	    public void setNombreProducto(String nombreProducto) {
	        this.nombreProducto = nombreProducto;
	    }

	    public Double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(Double precio) {
	        this.precio = precio;
	    }

	    public Date getFechaInicio() {
	        return fechaInicio;
	    }

	    public void setFechaInicio(Date fechaInicio) {
	        this.fechaInicio = fechaInicio;
	    }

	    public Date getFechaFin() {
	        return fechaFin;
	    }

	    public void setFechaFin(Date fechaFin) {
	        this.fechaFin = fechaFin;
	    }

	    public boolean isActivo() {
	        return activo;
	    }

	    public void setActivo(boolean activo) {
	        this.activo = activo;
	    }

}
