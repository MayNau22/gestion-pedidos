package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.presentacion.dto.request.ComprobantesPagoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ComprobantesPagoResponseDto;

@Mapper(componentModel = "spring")
public interface IComprobantesPagoDtoMapper {
    ComprobantesPago toDomain(ComprobantesPagoRequestDto requestDto);
    ComprobantesPagoResponseDto toResponseDto(ComprobantesPago dominio);
}