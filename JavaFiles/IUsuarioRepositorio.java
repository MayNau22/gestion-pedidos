package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {
	Usuario guardar(Usuario nuevoUsuario);
	Optional<Usuario> buscarPorId(int idUsuario);
	List<Usuario> listarTodos();
	void eliminar(int idUsuario);
}