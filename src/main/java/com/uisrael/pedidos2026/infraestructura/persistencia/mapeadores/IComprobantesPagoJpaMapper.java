package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;

@Mapper(componentModel = "spring")
public interface IComprobantesPagoJpaMapper {
	
	@Mapping(source = "pedido.idPedido", target = "idPedido")
	@Mapping(source = "estado.idEstado", target = "idEstado")
	ComprobantesPago toDomain(ComprobantesPagoEntity entity);

	@Mapping(target = "pedido.idPedido", source = "idPedido")
	@Mapping(target = "estado.idEstado", source = "idEstado")
	ComprobantesPagoEntity toEntity(ComprobantesPago comprobantesPago);
}