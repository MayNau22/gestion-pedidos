package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidosRequestDto {
	
	private int idProducto;
    @NotBlank
	private int idCategoria;
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
    @NotBlank
	private boolean disponible;
    @NotNull
	private Date fechaCreacion;

}
