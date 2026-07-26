package com.uisrael.pedidos2026.presentacion.dto.request;

import lombok.Data;

@Data
public class ComprobantesPagoRequestDto {
    private int idPedido;
    private String tipoPago;
    private String archivoUrl;
    private Double monto;
    private String observacion;
}