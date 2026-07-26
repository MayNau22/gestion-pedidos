package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;

@Mapper(componentModel = "spring")
public interface IPedidosJpaMapper {

	Pedidos toDomain(PedidosEntity entity);
	
	PedidosEntity toEntity(Pedidos pedidospojo);
	
}
