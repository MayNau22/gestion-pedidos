package com.uisrael.pedidos2026.presentacion.dto.request;

import lombok.Data;

@Data
public class EstadosGeneralesRequestDto {
    private String tipoEstado;
    private String nombre;
    private String descripcion;
    private String activo;
}