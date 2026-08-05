package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.RecuperacionPassword;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.RecuperacionPasswordEntity;

@Mapper(componentModel = "spring")
public interface IRecuperacionPasswordJpaMapper {

	RecuperacionPasswordEntity toEntity(RecuperacionPassword recuperacion);

	RecuperacionPassword toDominio(RecuperacionPasswordEntity entity);

}
