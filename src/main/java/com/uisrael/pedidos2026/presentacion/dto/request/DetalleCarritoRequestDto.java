package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleCarritoRequestDto {
	
	private int idDetalleCarrito;
	@NotBlank
	private int idCarrito;
	@NotBlank
	private int idProducto;
	@NotBlank
	private int cantidad;
	@NotBlank
	private double subtotal;

}
