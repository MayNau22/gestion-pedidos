package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comprobantes_pago")
public class ComprobantesPagoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComprobante;
	
	private String tipoPago;
	private String archivoUrl;
	private Double monto;
	private Date fechaSubida;
	private String observacion;
	

	@JoinColumn(name = "id_pedido")
	private PedidosEntity pedidoComprobante;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private EstadosGeneralesEntity estadoComprobante;

}

