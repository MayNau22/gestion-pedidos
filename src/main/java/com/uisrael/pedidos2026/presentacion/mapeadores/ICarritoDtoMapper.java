package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.presentacion.dto.request.CarritoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.CarritoResponseDto;

@Mapper(componentModel = "spring")
public interface ICarritoDtoMapper {
	
	Carrito toDomain(CarritoRequestDto dto);
	CarritoResponseDto toResponseDto(Carrito carritoPojo);
}
