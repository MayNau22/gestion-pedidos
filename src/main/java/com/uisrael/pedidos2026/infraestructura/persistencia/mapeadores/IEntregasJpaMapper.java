package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;

@Mapper(componentModel = "spring")
public interface IEntregasJpaMapper {
	
	@Mapping(source = "pedidoEntrega.idPedido", target = "idPedido")
    @Mapping(source = "estadoEntrega.idEstado", target = "idEstado")
    Entregas toDomain(EntregasEntity entity);

    @Mapping(source = "idPedido", target = "pedidoEntrega.idPedido")
    @Mapping(source = "idEstado", target = "estadoEntrega.idEstado")
    EntregasEntity toEntity(Entregas entregas);
}