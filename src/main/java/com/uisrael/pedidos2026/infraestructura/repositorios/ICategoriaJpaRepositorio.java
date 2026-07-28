package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;

public interface ICategoriaJpaRepositorio extends JpaRepository<CategoriaEntity, Integer>{
	
	List<CategoriaEntity> findByEstadoTrueOrderByNombreAsc();

}
