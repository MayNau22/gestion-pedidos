package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.presentacion.dto.request.DetallePedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetallePedidosResponseDto;

@Mapper(componentModel = "spring")
public interface IDetallePedidosDtoMapper {

	DetallePedidos toDomain(DetallePedidosRequestDto dto);
	
	DetallePedidosResponseDto toResponseDto(DetallePedidos detallepedidospojo);
}
