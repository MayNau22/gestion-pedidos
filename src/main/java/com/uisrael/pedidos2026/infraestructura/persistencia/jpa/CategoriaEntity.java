package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;

    private String nombre;
    private String descripcion;
    private String estado;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) 
    private List<ProductoEntity> productos;
}