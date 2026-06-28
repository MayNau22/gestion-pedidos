package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IEstadosGeneralesJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEstadosGeneralesJpaRepositorio;

public class EstadosGeneralesRepositorioImpl implements IEstadosGeneralesRepositorio {

	private final IEstadosGeneralesJpaRepositorio jpaRepositorio;
	private final IEstadosGeneralesJpaMapper entityMapper;

	public EstadosGeneralesRepositorioImpl(IEstadosGeneralesJpaRepositorio jpaRepositorio, IEstadosGeneralesJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EstadosGenerales guardar(EstadosGenerales nuevoEstado) {
		EstadosGeneralesEntity entity = entityMapper.toEntity(nuevoEstado);
		EstadosGeneralesEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<EstadosGenerales> buscarPorId(int idEstado) {
		return jpaRepositorio.findById(idEstado).map(entityMapper::toDomain);
	}

	@Override
	public List<EstadosGenerales> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEstado) {
		jpaRepositorio.deleteById(idEstado);
	}
}