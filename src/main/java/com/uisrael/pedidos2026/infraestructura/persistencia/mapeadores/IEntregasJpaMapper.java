package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;


@Mapper(componentModel = "spring")
public interface IEntregasJpaMapper {

	@Mapping(target = "pedidoEntrega", ignore = true)
    @Mapping(target = "estadoEntrega", ignore = true)
    EntregasEntity toEntity(Entregas domain);
}