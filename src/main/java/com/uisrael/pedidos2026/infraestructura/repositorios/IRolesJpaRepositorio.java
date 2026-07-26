package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.RolesEntity;

public interface IRolesJpaRepositorio extends JpaRepository<RolesEntity, Integer>{
	Optional<RolesEntity> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);
}
