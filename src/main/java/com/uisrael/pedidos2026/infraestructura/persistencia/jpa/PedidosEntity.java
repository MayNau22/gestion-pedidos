package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class PedidosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido; //
	private Date fechaPedido; //
	private Date fechaEntrega; //
	private String direccionEntrega; //
	private String observacion; //
	private Double total; //
	private int idEstado;


	
	@OneToMany(mappedBy = "fkPedidosEntity")
	private List<DetallePedidoEntity> detallePedidoEntity=new ArrayList<>();


	@OneToMany(mappedBy = "fkPedidosEntregaEntity")
	private List<EntregasEntity> entregasentity=new ArrayList<>();
	
	@OneToMany(mappedBy = "fkPedidosComprobantePagoEntity")
	private List<ComprobantesPagoEntity> comprobantespagoentity=new ArrayList<>();
	
	@ManyToAny
	@JoinColumn(name = "idUsuario")
	private UsuariosEntity fkUsuariosPedidoEntity;
	
}