package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.DetalleCarrito;
import com.uisrael.pedidos2026.dominio.repositorios.IDetalleCarritoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetalleCarritoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IDetalleCarritoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IDetalleCarritoJpaRepositorio;

public class DetalleCarritoRepositorioImpl implements IDetalleCarritoRepositorio{
	
	private final IDetalleCarritoJpaRepositorio jpaRepositorio;
	private final IDetalleCarritoJpaMapper entityMapper;

	
	public DetalleCarritoRepositorioImpl(IDetalleCarritoJpaRepositorio jpaRepositorio,
			IDetalleCarritoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetalleCarrito guardar(DetalleCarrito nuevoDetalleCarrito) {
		DetalleCarritoEntity entity = entityMapper.toEntity(nuevoDetalleCarrito);
		DetalleCarritoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetalleCarrito> buscarId(int idDetalleCarrito) {
		return jpaRepositorio.findById(idDetalleCarrito).map(entityMapper::toDomain);
	}

	@Override
	public List<DetalleCarrito> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalleCarrito) {
		jpaRepositorio.deleteById(idDetalleCarrito);
	}

}
