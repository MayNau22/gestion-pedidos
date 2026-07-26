package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.Usuario;

public interface IUsuarioUseCase {

	Usuario guardar(Usuario nuevoUsuario);

	Usuario buscarPorId(int idUsuario);

	List<Usuario> listarTodos();

	Usuario iniciarSesion(String correo, String contrasena);

	void eliminar(int idUsuario);

	void activar(int idUsuario);
	
	Usuario login(String correo, String contrasena);
}