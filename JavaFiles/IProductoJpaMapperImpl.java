package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IProductoJpaMapperImpl implements IProductoJpaMapper {

    @Override
    public Producto toDomain(ProductoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( entity.getIdProducto() );
        producto.setCategoria( categoriaEntityToCategoria( entity.getCategoria() ) );
        producto.setNombre( entity.getNombre() );
        producto.setDescripcion( entity.getDescripcion() );
        producto.setPrecio( entity.getPrecio() );
        producto.setStock( entity.getStock() );
        producto.setImagenUrl( entity.getImagenUrl() );
        producto.setDisponible( entity.isDisponible() );
        producto.setFechaCreacion( entity.getFechaCreacion() );

        return producto;
    }

    @Override
    public ProductoEntity toEntity(Producto productoPojo) {
        if ( productoPojo == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setIdProducto( productoPojo.getIdProducto() );
        productoEntity.setNombre( productoPojo.getNombre() );
        productoEntity.setDescripcion( productoPojo.getDescripcion() );
        productoEntity.setPrecio( productoPojo.getPrecio() );
        productoEntity.setStock( productoPojo.getStock() );
        productoEntity.setImagenUrl( productoPojo.getImagenUrl() );
        productoEntity.setDisponible( productoPojo.isDisponible() );
        if ( productoPojo.getFechaCreacion() != null ) {
            productoEntity.setFechaCreacion( new Date( productoPojo.getFechaCreacion().getTime() ) );
        }
        productoEntity.setCategoria( categoriaToCategoriaEntity( productoPojo.getCategoria() ) );

        return productoEntity;
    }

    protected Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( categoriaEntity.getIdCategoria() );
        categoria.setNombre( categoriaEntity.getNombre() );
        categoria.setDescripcion( categoriaEntity.getDescripcion() );
        if ( categoriaEntity.getEstado() != null ) {
            categoria.setEstado( Boolean.parseBoolean( categoriaEntity.getEstado() ) );
        }

        return categoria;
    }

    protected CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setIdCategoria( categoria.getIdCategoria() );
        categoriaEntity.setNombre( categoria.getNombre() );
        categoriaEntity.setDescripcion( categoria.getDescripcion() );
        categoriaEntity.setEstado( String.valueOf( categoria.isEstado() ) );

        return categoriaEntity;
    }
}
