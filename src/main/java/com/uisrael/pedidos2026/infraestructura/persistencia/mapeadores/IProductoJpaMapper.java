package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {
	
	//transforma la clase entity a una clase pojo
	Producto toDomain(ProductoEntity entity);
	//transforma - mapea la clase pojo a una entidad
	ProductoEntity  toEntity(Producto productoPojo);

}
