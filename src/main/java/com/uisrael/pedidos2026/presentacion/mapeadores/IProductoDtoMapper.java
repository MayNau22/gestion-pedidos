package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {
	
	Producto toDomain(ProductoRequestDto dto);
	ProductoResponseDto toResponseDto(Producto productoPojo);

}
