package com.uisrael.pedidos2026.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;


public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {
    // Spring Data implementará automáticamente las consultas básicas por nosotros
}