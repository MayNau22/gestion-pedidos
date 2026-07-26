package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetallePedidosRequestDto {
	private int idDetallePedido;
	@NotBlank
	private int cantidad;
	@NotBlank
	private double precioUnitario;
	@NotBlank
	private double subtotal;
	
	private int idProducto;
	
	private int idPedido;
}
