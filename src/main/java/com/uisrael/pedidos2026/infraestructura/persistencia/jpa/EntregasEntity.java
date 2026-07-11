package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
<<<<<<< HEAD
	private String tipoEntrega;
	private String recibidoPor;
	private String evidenciaEntregaUrl;
	private String observacion;
	private Date fechaEntregaReal;
=======
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "idPedido")
	private PedidosEntity pedido;
>>>>>>> branch 'master' of https://github.com/MayNau22/gestion-pedidos.git
	
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "idPedido")
	private PedidosEntity fkPedidosEntregaEntity;
	
	@ManyToOne
	@JoinColumn(name = "idEstado")
	private EstadosGeneralesEntity fkEstadosGeneralesEntregasEntity;
	
}
=======
	@JoinColumn(name = "id_estado", referencedColumnName = "idEstado")
	private EstadosGeneralesEntity estado;
	
	private String tipoEntrega; 
	private String recibidoPor; 
	private String evidenciaEntregaUrl; 
	private String observacion; 
	private Date fechaEntregaReal; 
	
}
>>>>>>> branch 'master' of https://github.com/MayNau22/gestion-pedidos.git
