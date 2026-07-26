package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {

	private final IUsuarioRepositorio repositorio;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {

		if (repositorio.existeCorreo(nuevoUsuario.getCorreo())) {

			throw new RuntimeException("El correo ya se encuentra registrado");
		}

		if (repositorio.existeCedula(nuevoUsuario.getCedula())) {

			throw new RuntimeException("La cédula ya se encuentra registrada");
		}

		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {

		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));
	}

	@Override
	public List<Usuario> listarTodos() {

		return repositorio.listarTodos();
	}

	@Override
	public Usuario iniciarSesion(String correo, String contrasena) {

		Usuario usuario = repositorio.buscarPorCorreo(correo)
				.orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos"));

		if (!"true".equalsIgnoreCase(usuario.getEstado())) {

			throw new RuntimeException("El usuario se encuentra inactivo");
		}


		if (!usuario.getContrasena().equals(contrasena)) {

			throw new RuntimeException("Correo o contraseña incorrectos");
		}

		return usuario;
	}

	@Override
	public void eliminar(int idUsuario) {

		repositorio.eliminar(idUsuario);
	}

	@Override
	public void activar(int idUsuario) {

		repositorio.activar(idUsuario);
	}

	@Override
	public Usuario login(String correo, String contrasena) {

	    Usuario usuario = repositorio.buscarPorCorreo(correo)
	            .orElseThrow(() ->
	                    new RuntimeException("Correo no registrado"));

	    if (!usuario.getContrasena().equals(contrasena)) {
	        throw new RuntimeException("Contraseña incorrecta");
	    }

	    if (!usuario.getEstado().equals("true")) {
	        throw new RuntimeException("Usuario inactivo");
	    }

	    return usuario;
	}
}