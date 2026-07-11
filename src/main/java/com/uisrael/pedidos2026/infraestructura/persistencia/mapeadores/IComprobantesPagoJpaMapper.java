package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;

@Mapper(componentModel = "spring")
public interface IComprobantesPagoJpaMapper {


	@Mapping(source = "pedidoComprobante.idPedido", target = "idPedido")
	@Mapping(source = "estadoComprobante.idEstado", target = "idEstado")
	ComprobantesPago toDomain(ComprobantesPagoEntity entity);

	@Mapping(source = "idPedido", target = "pedidoComprobante.idPedido")
	@Mapping(source = "idEstado", target = "estadoComprobante.idEstado")

	ComprobantesPagoEntity toEntity(ComprobantesPago comprobantesPago);
}