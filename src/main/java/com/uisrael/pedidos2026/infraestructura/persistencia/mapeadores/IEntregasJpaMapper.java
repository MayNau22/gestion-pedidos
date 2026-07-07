package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;

@Mapper(componentModel = "spring")
public interface IEntregasJpaMapper {
	
	@Mapping(source = "pedido.idPedido", target = "idPedido")
	@Mapping(source = "estado.idEstado", target = "idEstado")
	Entregas toDomain(EntregasEntity entity);

	@Mapping(target = "pedido.idPedido", source = "idPedido")
	@Mapping(target = "estado.idEstado", source = "idEstado")
	EntregasEntity toEntity(Entregas entregas);
}