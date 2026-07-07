package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;
import com.uisrael.pedidos2026.presentacion.dto.request.DetalleCarritoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetalleCarritoResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleCarritoDtoMapper {

    @Mapping(source = "idCarrito", target = "carrito.idCarrito")
    @Mapping(source = "idProducto", target = "producto.idProducto")
    DetalleCarrito toDomain(DetalleCarritoRequestDto dto);

    @Mapping(source = "carrito.idCarrito", target = "carrito")
    @Mapping(source = "producto.idProducto", target = "producto")
    DetalleCarritoResponseDto toResponseDto(DetalleCarrito detalleCarritoPojo);
}