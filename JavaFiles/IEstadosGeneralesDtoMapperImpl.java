package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.presentacion.dto.request.EstadosGeneralesRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EstadosGeneralesResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IEstadosGeneralesDtoMapperImpl implements IEstadosGeneralesDtoMapper {

    @Override
    public EstadosGenerales toDomain(EstadosGeneralesRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        EstadosGenerales estadosGenerales = new EstadosGenerales();

        estadosGenerales.setTipoEstado( requestDto.getTipoEstado() );
        estadosGenerales.setNombre( requestDto.getNombre() );
        estadosGenerales.setDescripcion( requestDto.getDescripcion() );
        estadosGenerales.setActivo( requestDto.getActivo() );

        return estadosGenerales;
    }

    @Override
    public EstadosGeneralesResponseDto toResponseDto(EstadosGenerales dominio) {
        if ( dominio == null ) {
            return null;
        }

        EstadosGeneralesResponseDto estadosGeneralesResponseDto = new EstadosGeneralesResponseDto();

        estadosGeneralesResponseDto.setIdEstado( dominio.getIdEstado() );
        estadosGeneralesResponseDto.setTipoEstado( dominio.getTipoEstado() );
        estadosGeneralesResponseDto.setNombre( dominio.getNombre() );
        estadosGeneralesResponseDto.setDescripcion( dominio.getDescripcion() );
        estadosGeneralesResponseDto.setActivo( dominio.getActivo() );

        return estadosGeneralesResponseDto;
    }
}
