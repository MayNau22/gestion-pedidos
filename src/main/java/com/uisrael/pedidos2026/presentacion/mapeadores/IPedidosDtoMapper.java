package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.PedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.PedidosResponseDto;

@Mapper(componentModel = "spring")
public interface IPedidosDtoMapper {
	Pedidos toDomain(PedidosRequestDto dto);
	
	PedidosResponseDto toResponseDto(Pedidos grupoPojo);

}
