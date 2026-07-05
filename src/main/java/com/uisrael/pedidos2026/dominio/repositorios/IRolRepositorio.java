package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Rol;

public interface IRolRepositorio {
	Rol guardar(Rol nuevoRol);
	Optional<Rol> buscarPorId(int idRol);
	List<Rol> listarTodos();
	void eliminar(int idRol);
}