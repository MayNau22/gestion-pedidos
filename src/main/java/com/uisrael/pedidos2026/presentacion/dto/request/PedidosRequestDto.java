package com.uisrael.pedidos2026.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidosRequestDto {

	private int idPedido;
	@NotBlank
	private Date fechaPedido;
	@NotBlank
	private Date fechaEntrega;
	@NotBlank
	private String direccionEntrega;
	@NotBlank
	private String observacion;
	@NotBlank
	private Double total;
	@NotBlank
	private int idEstado;
	@NotBlank
	private int idUsuario;
}
