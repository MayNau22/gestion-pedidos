package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedido;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.HistorialPedidosEntity;

@Mapper(componentModel = "spring")
public interface IHistorialPedidoJpaMapper {
	
	HistorialPedido toDomain(HistorialPedidosEntity entity);
	
	HistorialPedidosEntity toEntity(HistorialPedido historialPojo);
}