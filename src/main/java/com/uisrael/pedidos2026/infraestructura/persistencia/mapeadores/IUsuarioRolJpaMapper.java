package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.UsuarioRol;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioRolesEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioRolJpaMapper {
	
	UsuarioRol toDomain(UsuarioRolesEntity entity);
	
	UsuarioRolesEntity toEntity(UsuarioRol usuarioRolPojo);
}