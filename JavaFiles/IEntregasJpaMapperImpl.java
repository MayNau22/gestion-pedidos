package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IEntregasJpaMapperImpl implements IEntregasJpaMapper {

    @Override
    public Entregas toDomain(EntregasEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Entregas entregas = new Entregas();

        entregas.setIdEntrega( entity.getIdEntrega() );
        entregas.setTipoEntrega( entity.getTipoEntrega() );
        entregas.setRecibidoPor( entity.getRecibidoPor() );
        entregas.setEvidenciaEntregaUrl( entity.getEvidenciaEntregaUrl() );
        entregas.setObservacion( entity.getObservacion() );
        entregas.setFechaEntregaReal( entity.getFechaEntregaReal() );

        return entregas;
    }

    @Override
    public EntregasEntity toEntity(Entregas entregas) {
        if ( entregas == null ) {
            return null;
        }

        EntregasEntity entregasEntity = new EntregasEntity();

        entregasEntity.setEvidenciaEntregaUrl( entregas.getEvidenciaEntregaUrl() );
        entregasEntity.setFechaEntregaReal( entregas.getFechaEntregaReal() );
        entregasEntity.setIdEntrega( entregas.getIdEntrega() );
        entregasEntity.setObservacion( entregas.getObservacion() );
        entregasEntity.setRecibidoPor( entregas.getRecibidoPor() );
        entregasEntity.setTipoEntrega( entregas.getTipoEntrega() );

        return entregasEntity;
    }
}
