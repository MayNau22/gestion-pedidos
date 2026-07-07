package com.uisrael.pedidos2026.presentacion.dto.response;

import lombok.Data;

@Data
public class EstadosGeneralesResponseDto {
    private int idEstado;
    private String tipoEstado;
    private String nombre;
    private String descripcion;
    private String activo;
}