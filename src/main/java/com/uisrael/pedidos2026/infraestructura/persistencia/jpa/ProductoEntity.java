package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

   
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "idCategoria")
    private CategoriaEntity categoria; 

    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private String imagenUrl;
    private String disponible;
 
}