package com.uisrael.pedidos2026.dominio.entidades;

import java.util.Date;
import java.util.List;


public class Entregas {
    
	 private int idEntrega;
	    private int idPedido;
	    private int idEstado;

	    private String nombreEstado;
	    private String tipoEntrega;
	    private String recibidoPor;
	    private String evidenciaEntregaUrl;
	    private String observacion;

	    private Date fechaEntregaReal;
	    private String nombreCliente;
	    private String apellidoCliente;
	    private String celularCliente;
	    private String correoCliente;

	    private String direccionEntrega;
	    private Date fechaPedido;
	    private Date fechaEntregaSolicitada;
	    private Double totalPedido;

	    private List<DetallePedidos> detalles;

	    public Entregas() {
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

	    public String getNombreEstado() {
	        return nombreEstado;
	    }

	    public void setNombreEstado(String nombreEstado) {
	        this.nombreEstado = nombreEstado;
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

	    public String getNombreCliente() {
	        return nombreCliente;
	    }

	    public void setNombreCliente(String nombreCliente) {
	        this.nombreCliente = nombreCliente;
	    }

	    public String getApellidoCliente() {
	        return apellidoCliente;
	    }

	    public void setApellidoCliente(String apellidoCliente) {
	        this.apellidoCliente = apellidoCliente;
	    }

	    public String getCelularCliente() {
	        return celularCliente;
	    }

	    public void setCelularCliente(String celularCliente) {
	        this.celularCliente = celularCliente;
	    }

	    public String getCorreoCliente() {
	        return correoCliente;
	    }

	    public void setCorreoCliente(String correoCliente) {
	        this.correoCliente = correoCliente;
	    }

	    public String getDireccionEntrega() {
	        return direccionEntrega;
	    }

	    public void setDireccionEntrega(String direccionEntrega) {
	        this.direccionEntrega = direccionEntrega;
	    }

	    public Date getFechaPedido() {
	        return fechaPedido;
	    }

	    public void setFechaPedido(Date fechaPedido) {
	        this.fechaPedido = fechaPedido;
	    }

	    public Date getFechaEntregaSolicitada() {
	        return fechaEntregaSolicitada;
	    }

	    public void setFechaEntregaSolicitada(Date fechaEntregaSolicitada) {
	        this.fechaEntregaSolicitada = fechaEntregaSolicitada;
	    }

	    public Double getTotalPedido() {
	        return totalPedido;
	    }

	    public void setTotalPedido(Double totalPedido) {
	        this.totalPedido = totalPedido;
	    }

	    public List<DetallePedidos> getDetalles() {
	        return detalles;
	    }

	    public void setDetalles(List<DetallePedidos> detalles) {
	        this.detalles = detalles;
	    }
}