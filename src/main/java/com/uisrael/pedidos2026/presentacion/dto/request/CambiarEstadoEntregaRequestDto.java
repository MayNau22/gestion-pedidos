package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;

public class CambiarEstadoEntregaRequestDto {

    @NotNull(message = "El estado es obligatorio")
    private Integer idEstado;

    private String observacion;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}