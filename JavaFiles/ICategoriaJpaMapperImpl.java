package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class ICategoriaJpaMapperImpl implements ICategoriaJpaMapper {

    @Override
    public Categoria toDomain(CategoriaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( entity.getIdCategoria() );
        categoria.setNombre( entity.getNombre() );
        categoria.setDescripcion( entity.getDescripcion() );
        if ( entity.getEstado() != null ) {
            categoria.setEstado( Boolean.parseBoolean( entity.getEstado() ) );
        }

        return categoria;
    }

    @Override
    public CategoriaEntity toEntity(Categoria categoria) {
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
