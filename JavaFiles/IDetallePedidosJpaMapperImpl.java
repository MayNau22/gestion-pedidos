package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetallePedidoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IDetallePedidosJpaMapperImpl implements IDetallePedidosJpaMapper {

    @Override
    public DetallePedidos toDomain(DetallePedidoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DetallePedidos detallePedidos = new DetallePedidos();

        detallePedidos.setIdDetallePedido( entity.getIdDetallePedido() );
        detallePedidos.setCantidad( entity.getCantidad() );
        detallePedidos.setPrecioUnitario( entity.getPrecioUnitario() );
        detallePedidos.setSubtotal( entity.getSubtotal() );

        return detallePedidos;
    }

    @Override
    public DetallePedidoEntity toEntity(DetallePedidos detallepedidospojo) {
        if ( detallepedidospojo == null ) {
            return null;
        }

        DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();

        detallePedidoEntity.setCantidad( detallepedidospojo.getCantidad() );
        detallePedidoEntity.setIdDetallePedido( detallepedidospojo.getIdDetallePedido() );
        detallePedidoEntity.setPrecioUnitario( detallepedidospojo.getPrecioUnitario() );
        detallePedidoEntity.setSubtotal( detallepedidospojo.getSubtotal() );

        return detallePedidoEntity;
    }
}
