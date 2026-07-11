package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;

@Mapper(componentModel = "spring")
public interface IComprobantesPagoJpaMapper {
	
	
	ComprobantesPago toDomain(ComprobantesPagoEntity entity);

	ComprobantesPagoEntity toEntity(ComprobantesPago comprobantesPago);
}