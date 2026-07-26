package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.presentacion.dto.request.ComprobantesPagoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ComprobantesPagoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IComprobantesPagoDtoMapperImpl implements IComprobantesPagoDtoMapper {

    @Override
    public ComprobantesPago toDomain(ComprobantesPagoRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        ComprobantesPago comprobantesPago = new ComprobantesPago();

        comprobantesPago.setIdPedido( requestDto.getIdPedido() );
        comprobantesPago.setTipoPago( requestDto.getTipoPago() );
        comprobantesPago.setArchivoUrl( requestDto.getArchivoUrl() );
        comprobantesPago.setMonto( requestDto.getMonto() );
        comprobantesPago.setObservacion( requestDto.getObservacion() );

        return comprobantesPago;
    }

    @Override
    public ComprobantesPagoResponseDto toResponseDto(ComprobantesPago dominio) {
        if ( dominio == null ) {
            return null;
        }

        ComprobantesPagoResponseDto comprobantesPagoResponseDto = new ComprobantesPagoResponseDto();

        comprobantesPagoResponseDto.setIdComprobante( dominio.getIdComprobante() );
        comprobantesPagoResponseDto.setIdPedido( dominio.getIdPedido() );
        comprobantesPagoResponseDto.setTipoPago( dominio.getTipoPago() );
        comprobantesPagoResponseDto.setArchivoUrl( dominio.getArchivoUrl() );
        comprobantesPagoResponseDto.setMonto( dominio.getMonto() );
        comprobantesPagoResponseDto.setFechaSubida( dominio.getFechaSubida() );
        comprobantesPagoResponseDto.setIdEstado( dominio.getIdEstado() );
        comprobantesPagoResponseDto.setObservacion( dominio.getObservacion() );

        return comprobantesPagoResponseDto;
    }
}
