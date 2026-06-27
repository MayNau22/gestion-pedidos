package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carritos")
public class CarritosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	private int idUsuario;
	private Date fechaCreacion;

}