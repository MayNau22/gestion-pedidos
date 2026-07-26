package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.HistorialPedidosEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IHistorialPedidosJpaMapperImpl implements IHistorialPedidosJpaMapper {

    @Override
    public HistorialPedidos toDomain(HistorialPedidosEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HistorialPedidos historialPedidos = new HistorialPedidos();

        historialPedidos.setIdHistorial( entity.getIdHistorial() );
        historialPedidos.setIdEstadoAnterior( entity.getIdEstadoAnterior() );
        historialPedidos.setIdEstadoNuevo( entity.getIdEstadoNuevo() );
        historialPedidos.setObservacion( entity.getObservacion() );
        historialPedidos.setFecha( entity.getFecha() );
        historialPedidos.setUsuarioModifica( entity.getUsuarioModifica() );

        return historialPedidos;
    }

    @Override
    public HistorialPedidosEntity toEntity(HistorialPedidos historialPojo) {
        if ( historialPojo == null ) {
            return null;
        }

        HistorialPedidosEntity historialPedidosEntity = new HistorialPedidosEntity();

        historialPedidosEntity.setFecha( historialPojo.getFecha() );
        historialPedidosEntity.setIdEstadoAnterior( historialPojo.getIdEstadoAnterior() );
        historialPedidosEntity.setIdEstadoNuevo( historialPojo.getIdEstadoNuevo() );
        historialPedidosEntity.setIdHistorial( historialPojo.getIdHistorial() );
        historialPedidosEntity.setObservacion( historialPojo.getObservacion() );
        historialPedidosEntity.setUsuarioModifica( historialPojo.getUsuarioModifica() );

        return historialPedidosEntity;
    }
}
