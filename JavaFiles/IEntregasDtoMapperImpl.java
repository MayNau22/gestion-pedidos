package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.presentacion.dto.request.EntregasRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EntregasResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IEntregasDtoMapperImpl implements IEntregasDtoMapper {

    @Override
    public Entregas toDomain(EntregasRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Entregas entregas = new Entregas();

        entregas.setIdPedido( requestDto.getIdPedido() );
        entregas.setIdEstado( requestDto.getIdEstado() );
        entregas.setTipoEntrega( requestDto.getTipoEntrega() );
        entregas.setRecibidoPor( requestDto.getRecibidoPor() );
        entregas.setEvidenciaEntregaUrl( requestDto.getEvidenciaEntregaUrl() );
        entregas.setObservacion( requestDto.getObservacion() );

        return entregas;
    }

    @Override
    public EntregasResponseDto toResponseDto(Entregas dominio) {
        if ( dominio == null ) {
            return null;
        }

        EntregasResponseDto entregasResponseDto = new EntregasResponseDto();

        entregasResponseDto.setIdEntrega( dominio.getIdEntrega() );
        entregasResponseDto.setIdPedido( dominio.getIdPedido() );
        entregasResponseDto.setIdEstado( dominio.getIdEstado() );
        entregasResponseDto.setTipoEntrega( dominio.getTipoEntrega() );
        entregasResponseDto.setRecibidoPor( dominio.getRecibidoPor() );
        entregasResponseDto.setEvidenciaEntregaUrl( dominio.getEvidenciaEntregaUrl() );
        entregasResponseDto.setObservacion( dominio.getObservacion() );
        entregasResponseDto.setFechaEntregaReal( dominio.getFechaEntregaReal() );

        return entregasResponseDto;
    }
}
