package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.presentacion.dto.response.EntregasResponseDto;

@Mapper(componentModel = "spring")
public interface IEntregasDtoMapper {
	EntregasResponseDto toResponseDto(Entregas domain);
}