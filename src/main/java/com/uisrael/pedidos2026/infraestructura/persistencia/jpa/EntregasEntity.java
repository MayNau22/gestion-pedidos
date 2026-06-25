package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entregas")
public class EntregasEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntrega;
	
	private int idPedido;
	private int idEstado;
	private String tipoEntrega;
	private String recibidoPor;
	private String evidenciaEntregaUrl;
	private String observacion;
	private Date fechaEntregaReal;
	
}
