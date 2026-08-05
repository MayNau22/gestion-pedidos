package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.RecuperacionPasswordEntity;

public interface IRecuperacionPasswordJpaRepositorio extends JpaRepository<RecuperacionPasswordEntity, Integer> {

	Optional<RecuperacionPasswordEntity> findByToken(String token);

	Optional<RecuperacionPasswordEntity> findFirstByUsuarioIdUsuarioAndUtilizadoFalseOrderByFechaCreacionDesc(
			int idUsuario);
}