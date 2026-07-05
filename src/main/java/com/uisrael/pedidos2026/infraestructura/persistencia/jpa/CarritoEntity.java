package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carritos")
public class CarritoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	private int idUsuario;
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "carrito")
	private List<DetalleCarritoEntity> detalleCarrito = new ArrayList<>();
}