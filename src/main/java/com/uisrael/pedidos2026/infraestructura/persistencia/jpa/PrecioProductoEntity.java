package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(
    name = "precios_productos",
    indexes = {
        @Index(
            name = "idx_precio_producto",
            columnList = "id_producto"
        ),
        @Index(
            name = "idx_precio_activo",
            columnList = "id_producto, activo"
        )
    }
)
public class PrecioProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio")
    private int idPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_producto",
        nullable = false
    )
    private ProductoEntity producto;

    @Column(
        name = "precio",
        nullable = false
    )
    private Double precio;

    @Column(
        name = "fecha_inicio",
        nullable = false
    )
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(
        name = "activo",
        nullable = false
    )
    private boolean activo;
}