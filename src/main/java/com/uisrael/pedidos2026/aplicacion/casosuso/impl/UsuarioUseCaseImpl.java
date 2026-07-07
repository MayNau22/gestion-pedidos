package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {

	private final IUsuarioRepositorio repositorio;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<Usuario> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		repositorio.eliminar(idUsuario);
	}
}