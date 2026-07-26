package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;


public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {
    
	
	Optional<UsuarioEntity> findByCorreo(String correo);

    Optional<UsuarioEntity> findByCedula(String cedula);

    boolean existsByCorreo(String correo);

    boolean existsByCedula(String cedula);
}