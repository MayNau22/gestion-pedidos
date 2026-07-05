package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarritoRequestDto {
	
	private int idCarrito;
	@NotBlank
	private int idUsuario;
	@NotBlank
	private Date fechaCreacion;

}
