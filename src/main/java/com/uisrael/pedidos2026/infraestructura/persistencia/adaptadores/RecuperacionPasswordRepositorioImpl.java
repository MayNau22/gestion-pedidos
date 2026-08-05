package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.RecuperacionPassword;
import com.uisrael.pedidos2026.dominio.repositorios.IRecuperacionPasswordRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.RecuperacionPasswordEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IRecuperacionPasswordJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IRecuperacionPasswordJpaRepositorio;

public class RecuperacionPasswordRepositorioImpl implements IRecuperacionPasswordRepositorio {

	private final IRecuperacionPasswordJpaRepositorio jpa;

	private final IRecuperacionPasswordJpaMapper mapper;

	public RecuperacionPasswordRepositorioImpl(IRecuperacionPasswordJpaRepositorio jpa,
			IRecuperacionPasswordJpaMapper mapper) {
		super();
		this.jpa = jpa;
		this.mapper = mapper;
	}

	@Override
	public RecuperacionPassword guardar(RecuperacionPassword recuperacion) {

		RecuperacionPasswordEntity entity = mapper.toEntity(recuperacion);

		RecuperacionPasswordEntity guardado = jpa.save(entity);

		return mapper.toDominio(guardado);
	}

	@Override
	public Optional<RecuperacionPassword> buscarPorToken(String token) {

		return jpa.findByToken(token).map(mapper::toDominio);
	}
}
