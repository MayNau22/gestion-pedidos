package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedido;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.HistorialPedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IHistorialPedidoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IHistorialPedidoJpaRepositorio;

public class HistorialPedidoRepositoriosImpl implements IHistorialPedidoRepositorio {

	private final IHistorialPedidoJpaRepositorio jpaRepositorio;
	private final IHistorialPedidoJpaMapper entityMapper;
	
	public HistorialPedidoRepositoriosImpl(IHistorialPedidoJpaRepositorio jpaRepositorio, IHistorialPedidoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public HistorialPedido guardar(HistorialPedido nuevoHistorial) {
		HistorialPedidosEntity entity = entityMapper.toEntity(nuevoHistorial);
		HistorialPedidosEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<HistorialPedido> buscarPorId(int idHistorial) {
		return jpaRepositorio.findById(idHistorial).map(entityMapper::toDomain);
	}

	@Override
	public List<HistorialPedido> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idHistorial) {
		jpaRepositorio.deleteById(idHistorial);
	}
}