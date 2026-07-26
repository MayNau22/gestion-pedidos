package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.HistorialPedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.HistorialPedidosResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IHistorialPedidosDtoMapperImpl implements IHistorialPedidosDtoMapper {

    @Override
    public HistorialPedidos toDomain(HistorialPedidosRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        HistorialPedidos historialPedidos = new HistorialPedidos();

        historialPedidos.setIdHistorial( dto.getIdHistorial() );
        historialPedidos.setIdPedido( dto.getIdPedido() );
        historialPedidos.setIdEstadoAnterior( dto.getIdEstadoAnterior() );
        historialPedidos.setIdEstadoNuevo( dto.getIdEstadoNuevo() );
        historialPedidos.setObservacion( dto.getObservacion() );
        historialPedidos.setFecha( dto.getFecha() );
        historialPedidos.setUsuarioModifica( dto.getUsuarioModifica() );

        return historialPedidos;
    }

    @Override
    public HistorialPedidosResponseDto toResponseDto(HistorialPedidos historialpedidospojo) {
        if ( historialpedidospojo == null ) {
            return null;
        }

        HistorialPedidosResponseDto historialPedidosResponseDto = new HistorialPedidosResponseDto();

        historialPedidosResponseDto.setIdHistorial( historialpedidospojo.getIdHistorial() );
        historialPedidosResponseDto.setIdEstadoAnterior( historialpedidospojo.getIdEstadoAnterior() );
        historialPedidosResponseDto.setIdEstadoNuevo( historialpedidospojo.getIdEstadoNuevo() );
        historialPedidosResponseDto.setObservacion( historialpedidospojo.getObservacion() );
        historialPedidosResponseDto.setFecha( historialpedidospojo.getFecha() );
        historialPedidosResponseDto.setUsuarioModifica( historialpedidospojo.getUsuarioModifica() );
        historialPedidosResponseDto.setIdPedido( historialpedidospojo.getIdPedido() );

        return historialPedidosResponseDto;
    }
}
