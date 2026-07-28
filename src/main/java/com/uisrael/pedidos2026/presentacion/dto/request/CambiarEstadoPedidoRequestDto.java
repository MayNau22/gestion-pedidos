package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CambiarEstadoPedidoRequestDto {
	@NotNull(message = "El estado es obligatorio")
    private Integer idEstado;

    @NotNull(message = "El usuario es obligatorio")
    private Integer idUsuario;

    @NotBlank(message = "La observación es obligatoria")
    private String observacion;
}
