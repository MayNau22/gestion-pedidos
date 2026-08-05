package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {

	Usuario guardar(Usuario nuevoUsuario);

	Optional<Usuario> buscarPorId(int idUsuario);

	Optional<Usuario> buscarPorCorreo(String correo);

	List<Usuario> listarTodos();

	boolean existeCorreo(String correo);

	boolean existeCedula(String cedula);

	void eliminar(int idUsuario);

	void activar(int idUsuario);

	Usuario actualizar(Usuario usuario);

	Usuario actualizarContrasena(int idUsuario, String nuevaContrasena);

}