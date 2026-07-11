package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioJpaReposito;

public class UsuarioRepositorioImpl implements IUsuarioRepositorio{
	
	private final IUsuarioJpaReposito jpaRepositorio;
	private final IUsuarioJpaMapper entityMapper;

	public UsuarioRepositorioImpl(IUsuarioJpaReposito jpaRepositorio, IUsuarioJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		UsuarioEntity entity = entityMapper.toEntity(nuevoUsuario);
		UsuarioEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Usuario> buscarPorId(int idUsuario) {
		return jpaRepositorio.findById(idUsuario).map(entityMapper::toDomain);
	}

	@Override
	public List<Usuario> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idUsuario) {
		jpaRepositorio.deleteById(idUsuario);
	}

}
