package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PrecioProductoEntity;

public interface IPrecioProductoJpaRepositorio extends JpaRepository<PrecioProductoEntity, Integer>{
		 Optional<PrecioProductoEntity>findFirstByProductoIdProductoAndActivoTrue(int idProducto);

    List<PrecioProductoEntity>findByProductoIdProductoOrderByFechaInicioDesc(int idProducto);

    boolean existsByProductoIdProductoAndActivoTrue(int idProducto);
}
