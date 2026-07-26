package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.UsuarioRol;

public interface IUsuarioRolRepositorio {
	UsuarioRol guardar(UsuarioRol nuevoUsuarioRol);
	Optional<UsuarioRol> buscarPorId(int idUsuarioRol);
	List<UsuarioRol> listarTodos();
	void eliminar(int idUsuarioRol);
}