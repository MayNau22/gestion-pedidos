package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPedidosJpaMapperImpl implements IPedidosJpaMapper {

    @Override
    public Pedidos toDomain(PedidosEntity entity) {
        if ( entity == null ) {
            return null;
        }

        int idPedido = 0;
        Date fechaPedido = null;
        Date fechaEntrega = null;
        String direccionEntrega = null;
        String observacion = null;
        Double total = null;

        idPedido = entity.getIdPedido();
        fechaPedido = entity.getFechaPedido();
        fechaEntrega = entity.getFechaEntrega();
        direccionEntrega = entity.getDireccionEntrega();
        observacion = entity.getObservacion();
        total = entity.getTotal();

        int idUsuario = 0;
        int idEstado = 0;

        Pedidos pedidos = new Pedidos( idPedido, idUsuario, idEstado, fechaPedido, fechaEntrega, direccionEntrega, observacion, total );

        return pedidos;
    }

    @Override
    public PedidosEntity toEntity(Pedidos pedidospojo) {
        if ( pedidospojo == null ) {
            return null;
        }

        PedidosEntity pedidosEntity = new PedidosEntity();

        pedidosEntity.setDireccionEntrega( pedidospojo.getDireccionEntrega() );
        pedidosEntity.setFechaEntrega( pedidospojo.getFechaEntrega() );
        pedidosEntity.setFechaPedido( pedidospojo.getFechaPedido() );
        pedidosEntity.setIdPedido( pedidospojo.getIdPedido() );
        pedidosEntity.setObservacion( pedidospojo.getObservacion() );
        pedidosEntity.setTotal( pedidospojo.getTotal() );

        return pedidosEntity;
    }
}
