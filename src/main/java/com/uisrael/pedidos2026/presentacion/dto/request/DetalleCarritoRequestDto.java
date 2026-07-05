package com.uisrael.pedidos2026.presentacion.dto.request;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.dominio.entidades.Producto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleCarritoRequestDto {
	
	private int idDetalleCarrito;
	@NotBlank
	private Carrito idCarrito;
	@NotBlank
	private Producto idProducto;
	@NotBlank
	private double subtotal;

}
