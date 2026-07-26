package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.HistorialPedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.HistorialPedidosResponseDto;

@Mapper(componentModel = "spring")
public interface IHistorialPedidosDtoMapper {
	HistorialPedidos toDomain(HistorialPedidosRequestDto dto);
	
	HistorialPedidosResponseDto toResponseDto(HistorialPedidos historialpedidospojo);
}
