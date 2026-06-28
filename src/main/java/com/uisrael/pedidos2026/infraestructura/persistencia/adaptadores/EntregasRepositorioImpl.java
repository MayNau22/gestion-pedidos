package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IEntregasJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEntregasJpaRepositorio;

public class EntregasRepositorioImpl implements IEntregasRepositorio {

	private final IEntregasJpaRepositorio jpaRepositorio;
	private final IEntregasJpaMapper entityMapper;

	public EntregasRepositorioImpl(IEntregasJpaRepositorio jpaRepositorio, IEntregasJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Entregas guardar(Entregas nuevaEntrega) {
		EntregasEntity entity = entityMapper.toEntity(nuevaEntrega);
		EntregasEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Entregas> buscarPorId(int idEntrega) {
		return jpaRepositorio.findById(idEntrega).map(entityMapper::toDomain);
	}

	@Override
	public List<Entregas> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEntrega) {
		jpaRepositorio.deleteById(idEntrega);
	}
}