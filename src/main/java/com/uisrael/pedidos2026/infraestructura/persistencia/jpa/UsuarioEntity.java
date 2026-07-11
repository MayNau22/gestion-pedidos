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
@Table(name = "usuarios")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private String celular;
	private String estado;
	private Date fechaRegistro;
	
	
	@OneToMany(mappedBy = "usuarioCarrito")
	private List<CarritoEntity> carrito= 
	new ArrayList<>();
	
	
	@OneToMany(mappedBy = "usuarioPedido")
	private List<PedidosEntity> pedidos= 
	new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarioRol")
	private List<UsuarioRolesEntity> usuariosroles= 
	new ArrayList<>();
	

}