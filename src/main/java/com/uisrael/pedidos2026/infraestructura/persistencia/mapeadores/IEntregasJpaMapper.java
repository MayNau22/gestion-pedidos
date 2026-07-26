package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEntregasJpaMapper {

    // Convierte EntregasEntity (BD) a Entregas (Dominio) extrayendo IDs de los objetos anidados
    @Mapping(source = "pedidoEntrega.idPedido", target = "idPedido")
    @Mapping(source = "estadoEntrega.idEstado", target = "idEstado")
    Entregas toDomain(EntregasEntity entity);

    // Convierte Entregas (Dominio) a EntregasEntity (BD) asignando los IDs a los objetos anidados
    @Mapping(source = "idPedido", target = "pedidoEntrega.idPedido")
    @Mapping(source = "idEstado", target = "estadoEntrega.idEstado")
    EntregasEntity toEntity(Entregas entregas);

    // Convierte listas completas
    List<Entregas> toDomainList(List<EntregasEntity> entities);
}