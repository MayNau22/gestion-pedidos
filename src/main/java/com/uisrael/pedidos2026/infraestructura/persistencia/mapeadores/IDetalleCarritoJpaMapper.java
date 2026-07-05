package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetalleCarritoEntity;

@Mapper(componentModel = "spring")
public interface IDetalleCarritoJpaMapper {
	
	DetalleCarrito toDomain(DetalleCarritoEntity entity);
	DetalleCarritoEntity toEntity(DetalleCarrito detalleCarrito);
}
