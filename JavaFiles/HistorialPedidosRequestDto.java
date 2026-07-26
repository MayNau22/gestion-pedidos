package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HistorialPedidosRequestDto {
	private int idHistorial;
	@NotBlank
	private int idEstadoAnterior;
	@NotBlank
	private int idEstadoNuevo;
	@NotBlank
	private String observacion;
	@NotBlank
	private Date fecha;
	@NotBlank
	private int usuarioModifica;
	
	private int idPedido;
	
	private int idUsuario;
	
}
