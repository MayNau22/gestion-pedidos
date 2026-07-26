package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioRolesEntity;

public interface IUsuarioRolJpaRepositorio extends JpaRepository<UsuarioRolesEntity, Integer> {
	
	List<UsuarioRolesEntity> findByUsuarioRol_IdUsuario(int idUsuario);

	boolean existsByUsuarioRol_IdUsuarioAndRol_IdRol(int idUsuario, int idRol);
}