package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CarritosEntity;

@Mapper(componentModel = "spring")
public interface ICarritoJpaMapper {
	
	Carrito toDomain(CarritosEntity entity);
	
	CarritosEntity toEntity(Carrito carritoPojo);
}