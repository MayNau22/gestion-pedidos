package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CarritoEntity;

@Mapper(componentModel = "spring")
public interface ICarritoJpaMapper {
	
	Carrito toDomain(CarritoEntity entity);
	CarritoEntity toEntity(Carrito carrito);
}
