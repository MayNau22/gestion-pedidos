package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;

public interface IPedidosJpaRepositorios extends JpaRepository<PedidosEntity, Integer> {
	List<PedidosEntity> findByUsuarioPedidoIdUsuario(int idUsuario);
}
