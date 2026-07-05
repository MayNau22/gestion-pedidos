package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;
import com.uisrael.pedidos2026.presentacion.dto.request.DetalleCarritoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetalleCarritoResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleCarritoDtoMapper {
	
	DetalleCarrito toDomain(DetalleCarritoRequestDto dto);
	DetalleCarritoResponseDto toResponseDto(DetalleCarrito detalleCarritoPojo);
}
