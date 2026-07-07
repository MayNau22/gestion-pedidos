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
@Table(name = "entregas")
public class EntregasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntrega; 
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "idPedido")
	private PedidosEntity pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "idEstado")
	private EstadosGeneralesEntity estado;
	
	private String tipoEntrega; 
	private String recibidoPor; 
	private String evidenciaEntregaUrl; 
	private String observacion; 
	private Date fechaEntregaReal; 
	
}