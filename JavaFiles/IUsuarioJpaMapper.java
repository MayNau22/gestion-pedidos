package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {
	
	Usuario toDomain(UsuarioEntity entity);
	UsuarioEntity toEntity(Usuario usuarioPojo);

}
