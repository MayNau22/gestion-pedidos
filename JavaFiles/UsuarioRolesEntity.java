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
@Table(name = "usuario_roles")
public class UsuarioRolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioRol; // Llave primaria autoincremental para control de JPA
	
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuarioRol;
	
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private RolesEntity rol;

}