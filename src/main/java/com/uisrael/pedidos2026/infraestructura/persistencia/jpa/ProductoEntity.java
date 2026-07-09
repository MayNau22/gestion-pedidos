package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private List<DetalleCarritoEntity> detalleCarritos = new ArrayList<>();
	
	
	@OneToMany(mappedBy ="detallePedido" )
	private List<DetallePedidoEntity> detallePedidos = new ArrayList<>() ;


}
