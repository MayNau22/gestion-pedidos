package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CambiarEstadoComprobanteRequestDto {
	
	 @NotNull(message = "El estado es obligatorio")
	    private Integer idEstado;

	    private String observacion;
}
