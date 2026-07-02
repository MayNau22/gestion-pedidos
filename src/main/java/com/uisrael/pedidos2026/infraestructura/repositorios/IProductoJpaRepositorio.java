package com.uisrael.pedidos2026.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import java.util.List;


public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer> {
	
	List<ProductoEntity> findByNombre(String nombre);

}
