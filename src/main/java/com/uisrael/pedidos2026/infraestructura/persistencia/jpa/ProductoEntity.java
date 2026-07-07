package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductoEntity {
<<<<<<< HEAD
	
=======

>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	private String imagenUrl;
	private boolean disponible;
	private Date fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoria; 
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleCarritoEntity> detalleCarrito = new ArrayList<>();
<<<<<<< HEAD
=======


>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
   
 
}