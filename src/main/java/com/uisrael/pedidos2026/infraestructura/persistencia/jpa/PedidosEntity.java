package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class PedidosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private Date fechaPedido;
	private Date fechaEntrega;
	private String direccionEntrega;
	private String observacion;
	private Double total;
	
	@OneToMany(mappedBy = "pedido")
	private List<DetallePedidoEntity> detallePedido = new ArrayList<>();


	@OneToMany(mappedBy = "pedidoEntrega")
	private List<EntregasEntity> entregasentity=new ArrayList<>();
	
	@OneToMany(mappedBy = "pedidoComprobante")
	private List<ComprobantesPagoEntity> comprobantePagos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioPedido;
	
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private EstadosGeneralesEntity estadoPedido;
}

