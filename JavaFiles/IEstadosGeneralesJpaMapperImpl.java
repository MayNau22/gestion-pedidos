package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IEstadosGeneralesJpaMapperImpl implements IEstadosGeneralesJpaMapper {

    @Override
    public EstadosGenerales toDomain(EstadosGeneralesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EstadosGenerales estadosGenerales = new EstadosGenerales();

        estadosGenerales.setIdEstado( entity.getIdEstado() );
        estadosGenerales.setTipoEstado( entity.getTipoEstado() );
        estadosGenerales.setNombre( entity.getNombre() );
        estadosGenerales.setDescripcion( entity.getDescripcion() );
        estadosGenerales.setActivo( entity.getActivo() );

        return estadosGenerales;
    }

    @Override
    public EstadosGeneralesEntity toEntity(EstadosGenerales estadosGenerales) {
        if ( estadosGenerales == null ) {
            return null;
        }

        EstadosGeneralesEntity estadosGeneralesEntity = new EstadosGeneralesEntity();

        estadosGeneralesEntity.setActivo( estadosGenerales.getActivo() );
        estadosGeneralesEntity.setDescripcion( estadosGenerales.getDescripcion() );
        estadosGeneralesEntity.setIdEstado( estadosGenerales.getIdEstado() );
        estadosGeneralesEntity.setNombre( estadosGenerales.getNombre() );
        estadosGeneralesEntity.setTipoEstado( estadosGenerales.getTipoEstado() );

        return estadosGeneralesEntity;
    }
}
