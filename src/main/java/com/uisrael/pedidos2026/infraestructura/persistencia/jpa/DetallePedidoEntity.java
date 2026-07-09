package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

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
@Table(name = "detalle_pedidos")
public class DetallePedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;
	private int cantidad;
	private double precioUnitario;
	private double subtotal;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido") 
	private PedidosEntity pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_producto") 
	private ProductoEntity detallePedido;


}
