package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.PedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.PedidosResponseDto;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPedidosDtoMapperImpl implements IPedidosDtoMapper {

    @Override
    public Pedidos toDomain(PedidosRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        int idPedido = 0;
        int idUsuario = 0;
        int idEstado = 0;
        Date fechaPedido = null;
        Date fechaEntrega = null;
        String direccionEntrega = null;
        String observacion = null;
        Double total = null;

        idPedido = dto.getIdPedido();
        idUsuario = dto.getIdUsuario();
        idEstado = dto.getIdEstado();
        fechaPedido = dto.getFechaPedido();
        fechaEntrega = dto.getFechaEntrega();
        direccionEntrega = dto.getDireccionEntrega();
        observacion = dto.getObservacion();
        total = dto.getTotal();

        Pedidos pedidos = new Pedidos( idPedido, idUsuario, idEstado, fechaPedido, fechaEntrega, direccionEntrega, observacion, total );

        return pedidos;
    }

    @Override
    public PedidosResponseDto toResponseDto(Pedidos pedidospojo) {
        if ( pedidospojo == null ) {
            return null;
        }

        PedidosResponseDto pedidosResponseDto = new PedidosResponseDto();

        pedidosResponseDto.setIdPedido( pedidospojo.getIdPedido() );
        pedidosResponseDto.setFechaPedido( pedidospojo.getFechaPedido() );
        pedidosResponseDto.setFechaEntrega( pedidospojo.getFechaEntrega() );
        pedidosResponseDto.setDireccionEntrega( pedidospojo.getDireccionEntrega() );
        pedidosResponseDto.setObservacion( pedidospojo.getObservacion() );
        pedidosResponseDto.setTotal( pedidospojo.getTotal() );
        pedidosResponseDto.setIdEstado( pedidospojo.getIdEstado() );
        pedidosResponseDto.setIdUsuario( pedidospojo.getIdUsuario() );

        return pedidosResponseDto;
    }
}
