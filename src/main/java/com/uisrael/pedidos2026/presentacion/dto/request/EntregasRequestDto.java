package com.uisrael.pedidos2026.presentacion.dto.request;

public class EntregasRequestDto {

    private Integer idPedido;
    private Integer idEstado;
    private String tipoEntrega;
    private String recibidoPor;
    private String observacion;
    private String evidenciaEntregaUrl;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEvidenciaEntregaUrl() {
        return evidenciaEntregaUrl;
    }

    public void setEvidenciaEntregaUrl(String evidenciaEntregaUrl) {
        this.evidenciaEntregaUrl = evidenciaEntregaUrl;
    }
}