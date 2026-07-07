package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class PedidosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido; //
	
	private int idUsuario; //
	
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "idEstado")
	private EstadosGeneralesEntity estado;
	
	private Date fechaPedido; //
	private Date fechaEntrega; //
	private String direccionEntrega; //
	private String observacion; //
	private Double total; //

}