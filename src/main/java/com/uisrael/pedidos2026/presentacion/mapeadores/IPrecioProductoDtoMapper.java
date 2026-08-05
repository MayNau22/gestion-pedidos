package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.PrecioProducto;
import com.uisrael.pedidos2026.presentacion.dto.response.PrecioProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IPrecioProductoDtoMapper {

    PrecioProductoResponseDto toResponseDto(
        PrecioProducto precioProducto
    );
}