package com.uisrael.pedidos2026.presentacion.dto.response;

import java.util.Date;
import lombok.Data;

@Data
public class EntregasResponseDto {
    private int idEntrega;
    private int idPedido;
    private int idEstado;
    private String tipoEntrega;
    private String recibidoPor;
    private String evidenciaEntregaUrl;
    private String observacion;
    private Date fechaEntregaReal;
}