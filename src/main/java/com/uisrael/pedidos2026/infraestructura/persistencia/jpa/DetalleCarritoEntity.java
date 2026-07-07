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
@Table(name = "detalle_carritos")
public class DetalleCarritoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleCarrito;
	private int cantidad;
	private double subtotal;
	@ManyToOne
	@JoinColumn(name="id_carrito")
	private CarritoEntity carrito;
	
	@ManyToOne
<<<<<<< HEAD
=======

>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
	@JoinColumn(name="id_producto")
	private ProductoEntity producto;


}
