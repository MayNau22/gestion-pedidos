package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.CategoriaResponseDto;

@Mapper(componentModel = "spring")
public interface ICategoriaDtoMapper {

	Categoria toDomain(CategoriaRequestDto dto);
	CategoriaResponseDto toResponseDto(Categoria categoriaPojo);
}
