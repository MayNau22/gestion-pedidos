package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.UsuarioRol;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRolRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioRolesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IUsuarioRolJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioRolJpaRepositorio;

public class UsuarioRolRepositoriosImpl implements IUsuarioRolRepositorio {

	private final IUsuarioRolJpaRepositorio jpaRepositorio;
	private final IUsuarioRolJpaMapper entityMapper;
	
	public UsuarioRolRepositoriosImpl(IUsuarioRolJpaRepositorio jpaRepositorio, IUsuarioRolJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public UsuarioRol guardar(UsuarioRol nuevoUsuarioRol) {
		UsuarioRolesEntity entity = entityMapper.toEntity(nuevoUsuarioRol);
		UsuarioRolesEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<UsuarioRol> buscarPorId(int idUsuarioRol) {
		return jpaRepositorio.findById(idUsuarioRol).map(entityMapper::toDomain);
	}

	@Override
	public List<UsuarioRol> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idUsuarioRol) {
		jpaRepositorio.deleteById(idUsuarioRol);
	}
}