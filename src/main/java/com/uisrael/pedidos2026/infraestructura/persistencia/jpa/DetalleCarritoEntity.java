package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_carritos")
public class DetalleCarritoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleCarrito;
	private int idCarrito;
	private int idProducto;
	private double subtotal;

}
