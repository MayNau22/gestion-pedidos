package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comprobantes_pago")
public class ComprobantesPagoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComprobante;
	
	private int idPedido;
	private String tipoPago;
	private String archivoUrl;
	private Double monto;
	private Date fechaSubida;
	private int idEstado;
	private String observacion;


}
