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


   
 
}