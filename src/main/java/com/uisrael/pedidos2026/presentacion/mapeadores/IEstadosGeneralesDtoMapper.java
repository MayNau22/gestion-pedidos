package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.presentacion.dto.request.EstadosGeneralesRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EstadosGeneralesResponseDto;

@Mapper(componentModel = "spring")
public interface IEstadosGeneralesDtoMapper {
    EstadosGenerales toDomain(EstadosGeneralesRequestDto requestDto);
    EstadosGeneralesResponseDto toResponseDto(EstadosGenerales dominio);
}