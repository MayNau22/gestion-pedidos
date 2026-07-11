package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.HistorialPedidosEntity;

@Mapper(componentModel = "spring")
public interface IHistorialPedidosJpaMapper {
	
	HistorialPedidos toDomain(HistorialPedidosEntity entity);
	
	HistorialPedidosEntity toEntity(HistorialPedidos historialPojo);
}