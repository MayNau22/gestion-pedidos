package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoRequestDto {
	
	private int idProducto;
	
	private int categoria;
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private Double precio;
	@NotBlank
	private int stock;
	@NotBlank
	private String imagenUrl;
	private boolean disponible;
	@NotBlank
	private Date fechaCreacion;
	


}
