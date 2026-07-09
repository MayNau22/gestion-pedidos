package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "historial_pedidos")
public class HistorialPedidosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorial;
	private int idEstadoAnterior;
	private int idEstadoNuevo;
	private String observacion;
	private Date fecha;
	private int usuarioModifica;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido") 
	private PedidosEntity pedido;
	

}