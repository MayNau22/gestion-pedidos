package com.uisrael.pedidos2026.presentacion.dto.response;

import java.util.Date;
import lombok.Data;

@Data
public class ComprobantesPagoResponseDto {
	
    private int idComprobante;
    private int idPedido;
    private String tipoPago;
    private String archivoUrl;
    private Double monto;
    private Date fechaSubida;
    private int idEstado;
    private String observacion;
    
    
}