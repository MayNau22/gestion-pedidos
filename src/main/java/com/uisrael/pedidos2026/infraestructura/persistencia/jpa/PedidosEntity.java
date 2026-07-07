package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.List;

import org.hibernate.annotations.ManyToAny;

>>>>>>> branch 'master' of https://github.com/MayNau22/gestion-pedidos.git
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
<<<<<<< HEAD
	private int idUsuario; //
	
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "idEstado")
	private EstadosGeneralesEntity estado;
	
	private Date fechaPedido; //
	private Date fechaEntrega; //
	private String direccionEntrega; //
	private String observacion; //
	private Double total; //
=======
	private int idUsuario;
	private int idEstado;
	private Date fechaPedido;
	private Date fechaEntrega;
	private String direccionEntrega;
	private String observacion;
	private Double total;
	
	@OneToMany(mappedBy = "fkPedidosEntity")
	private List<DetallePedidoEntity> detallePedidoEntity=new ArrayList<>();


	@OneToMany(mappedBy = "fkPedidosEntregaEntity")
	private List<EntregasEntity> entregasentity=new ArrayList<>();
	
	@OneToMany(mappedBy = "fkPedidosComprobantePagoEntity")
	private List<ComprobantesPagoEntity> comprobantespagoentity=new ArrayList<>();
	
	@ManyToAny
	@JoinColumn(name = "idUsuario")
	private UsuariosEntity fkUsuariosPedidoEntity;
	
>>>>>>> branch 'master' of https://github.com/MayNau22/gestion-pedidos.git

}