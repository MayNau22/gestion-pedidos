package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetallePedidosRequestDto {

    @NotNull(message = "El producto es obligatorio")
    private Integer idProducto;

    @Min(
        value = 1,
        message = "La cantidad debe ser mayor que cero"
    )
    private int cantidad;
}