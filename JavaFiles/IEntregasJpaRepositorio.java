package com.uisrael.pedidos2026.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;

public interface IEntregasJpaRepositorio extends JpaRepository<EntregasEntity, Integer> {
}