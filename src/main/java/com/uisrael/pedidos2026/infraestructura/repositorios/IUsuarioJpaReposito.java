package com.uisrael.pedidos2026.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioJpaReposito extends JpaRepository<UsuarioEntity, Integer>{

}
