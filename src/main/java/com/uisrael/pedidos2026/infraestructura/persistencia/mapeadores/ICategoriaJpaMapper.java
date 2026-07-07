package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;

@Mapper(componentModel = "spring")
public interface ICategoriaJpaMapper {
	
	Categoria toDomain(CategoriaEntity entity);
	CategoriaEntity toEntity(Categoria categoria);

}
