package com.uisrael.pedidos2026.presentacion.dto.request;

import lombok.Data;

@Data
public class EntregasRequestDto {
    private int idPedido;
    private int idEstado;
    private String tipoEntrega;
    private String recibidoPor;
    private String evidenciaEntregaUrl;
    private String observacion;
}