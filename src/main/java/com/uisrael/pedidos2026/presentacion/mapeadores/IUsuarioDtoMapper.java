package com.uisrael.pedidos2026.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.presentacion.dto.request.UsuarioRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.UsuarioResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

	Usuario toDomain(UsuarioRequestDto usuarioRequestDto);

	UsuarioResponseDto toResponseDto(Usuario usuario);
}