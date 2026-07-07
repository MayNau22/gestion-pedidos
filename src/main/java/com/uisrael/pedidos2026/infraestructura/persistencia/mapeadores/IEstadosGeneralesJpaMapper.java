package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;

@Mapper(componentModel = "spring")
public interface IEstadosGeneralesJpaMapper {
	
	EstadosGenerales toDomain(EstadosGeneralesEntity entity);
	EstadosGeneralesEntity toEntity(EstadosGenerales estadosGenerales);
}