package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetallePedidoEntity;

@Mapper(componentModel = "spring")
public interface IDetallePedidosJpaMapper {
	
	DetallePedidos toDomain(DetallePedidoEntity entity);
	
	DetallePedidoEntity toEntity(DetallePedidos detallepedidospojo);

}
