package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======


>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
public class CarritoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	private int idUsuario;
	private Date fechaCreacion;
<<<<<<< HEAD
=======

>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
	
	@OneToMany(mappedBy = "carrito")
	private List<DetalleCarritoEntity> detalleCarritos = new ArrayList<>();

<<<<<<< HEAD
=======

>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
}