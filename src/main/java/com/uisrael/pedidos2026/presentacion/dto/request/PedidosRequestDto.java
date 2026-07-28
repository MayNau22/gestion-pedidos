package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PedidosRequestDto {

    private int idPedido;

    private Date fechaPedido;

    @NotNull(message = "La fecha de entrega es obligatoria")
    @FutureOrPresent(
        message = "La fecha de entrega no puede ser anterior a la fecha actual"
    )
    private Date fechaEntrega;

    @NotNull(message = "La dirección de entrega es obligatoria")
    @Size(
        min = 5,
        max = 500,
        message = "La dirección debe tener entre 5 y 500 caracteres"
    )
    private String direccionEntrega;

    private String observacion;

    private Double total;


    private int idEstado;

    @NotNull(message = "El usuario es obligatorio")
    private Integer idUsuario;

    @Valid
    @NotEmpty(message = "El pedido debe contener al menos un producto")
    private List<DetallePedidosRequestDto> detalles;
}