package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IComprobantesPagoJpaMapperImpl implements IComprobantesPagoJpaMapper {

    @Override
    public ComprobantesPago toDomain(ComprobantesPagoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ComprobantesPago comprobantesPago = new ComprobantesPago();

        comprobantesPago.setIdComprobante( entity.getIdComprobante() );
        comprobantesPago.setTipoPago( entity.getTipoPago() );
        comprobantesPago.setArchivoUrl( entity.getArchivoUrl() );
        comprobantesPago.setMonto( entity.getMonto() );
        comprobantesPago.setFechaSubida( entity.getFechaSubida() );
        comprobantesPago.setObservacion( entity.getObservacion() );

        return comprobantesPago;
    }

    @Override
    public ComprobantesPagoEntity toEntity(ComprobantesPago comprobantesPago) {
        if ( comprobantesPago == null ) {
            return null;
        }

        ComprobantesPagoEntity comprobantesPagoEntity = new ComprobantesPagoEntity();

        comprobantesPagoEntity.setArchivoUrl( comprobantesPago.getArchivoUrl() );
        comprobantesPagoEntity.setFechaSubida( comprobantesPago.getFechaSubida() );
        comprobantesPagoEntity.setIdComprobante( comprobantesPago.getIdComprobante() );
        comprobantesPagoEntity.setMonto( comprobantesPago.getMonto() );
        comprobantesPagoEntity.setObservacion( comprobantesPago.getObservacion() );
        comprobantesPagoEntity.setTipoPago( comprobantesPago.getTipoPago() );

        return comprobantesPagoEntity;
    }
}
