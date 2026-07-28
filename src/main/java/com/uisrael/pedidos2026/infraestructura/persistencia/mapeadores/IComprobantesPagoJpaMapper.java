package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;

@Mapper(componentModel = "spring")
public interface IComprobantesPagoJpaMapper {

	@Mapping(target = "idPedido", source = "pedidoComprobante.idPedido")
	@Mapping(target = "idEstado", source = "estadoComprobante.idEstado")
	ComprobantesPago toDomain(ComprobantesPagoEntity entity);

	@Mapping(target = "pedidoComprobante", ignore = true)
	@Mapping(target = "estadoComprobante", ignore = true)
	ComprobantesPagoEntity toEntity(ComprobantesPago domain);
}