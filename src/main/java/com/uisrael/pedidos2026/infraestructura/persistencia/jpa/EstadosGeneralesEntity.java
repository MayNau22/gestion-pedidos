package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estados_generales")
public class EstadosGeneralesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idEstado;
	
	private String tipoEstado;
	private String nombre;
	private String descripcion;
	private String activo;

}
