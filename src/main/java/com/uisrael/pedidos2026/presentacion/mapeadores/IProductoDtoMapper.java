package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {
	
	@Mapping(source = "categoria", target = "categoria.idCategoria")
    Producto toDomain(ProductoRequestDto dto);

    ProductoResponseDto toResponseDto(Producto productoPojo);

}

