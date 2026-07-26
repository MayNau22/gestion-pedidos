package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.DetallePedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetallePedidosResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IDetallePedidosDtoMapperImpl implements IDetallePedidosDtoMapper {

    @Override
    public DetallePedidos toDomain(DetallePedidosRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DetallePedidos detallePedidos = new DetallePedidos();

        detallePedidos.setIdDetallePedido( dto.getIdDetallePedido() );
        detallePedidos.setIdPedido( dto.getIdPedido() );
        detallePedidos.setIdProducto( dto.getIdProducto() );
        detallePedidos.setCantidad( dto.getCantidad() );
        detallePedidos.setPrecioUnitario( dto.getPrecioUnitario() );
        detallePedidos.setSubtotal( dto.getSubtotal() );

        return detallePedidos;
    }

    @Override
    public DetallePedidosResponseDto toResponseDto(DetallePedidos detallepedidospojo) {
        if ( detallepedidospojo == null ) {
            return null;
        }

        DetallePedidosResponseDto detallePedidosResponseDto = new DetallePedidosResponseDto();

        detallePedidosResponseDto.setIdDetallePedido( detallepedidospojo.getIdDetallePedido() );
        detallePedidosResponseDto.setCantidad( detallepedidospojo.getCantidad() );
        detallePedidosResponseDto.setPrecioUnitario( detallepedidospojo.getPrecioUnitario() );
        detallePedidosResponseDto.setSubtotal( detallepedidospojo.getSubtotal() );
        detallePedidosResponseDto.setIdProducto( detallepedidospojo.getIdProducto() );
        detallePedidosResponseDto.setIdPedido( detallepedidospojo.getIdPedido() );

        return detallePedidosResponseDto;
    }
}
