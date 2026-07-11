package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.HistorialPedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IHistorialPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IHistorialPedidosJpaRepositorios;

@Repository
public class HistorialPedidoRepositoriosImpl implements IHistorialPedidoRepositorio {

	private final IHistorialPedidosJpaRepositorios jpaRepositorio;
	private final IHistorialPedidosJpaMapper entityMapper;
	public HistorialPedidoRepositoriosImpl(IHistorialPedidosJpaRepositorios jpaRepositorio,
			IHistorialPedidosJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public HistorialPedidos guardar(HistorialPedidos nuevoHistorial) {
		HistorialPedidosEntity entity = entityMapper.toEntity(nuevoHistorial);
		HistorialPedidosEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<HistorialPedidos> buscarPorId(int idHistorial) {
		return jpaRepositorio.findById(idHistorial).map(entityMapper::toDomain);
	}

	@Override
	public List<HistorialPedidos> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idHistorial) {
		jpaRepositorio.deleteById(idHistorial);
	}


}