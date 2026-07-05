package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Carrito;
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CarritoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICarritoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICarritoJpaRepositorio;



public class CarritoRepositorioImpl implements ICarritoRepositorio{
	
	private final ICarritoJpaRepositorio jpaRepositorio;
	private final ICarritoJpaMapper entityMapper;	

	public CarritoRepositorioImpl(ICarritoJpaRepositorio jpaRepositorio, ICarritoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Carrito guardar(Carrito nuevoCarrito) {
		CarritoEntity entity = entityMapper.toEntity(nuevoCarrito);
		CarritoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Carrito> buscarId(int idCarrito) {
		return jpaRepositorio.findById(idCarrito).map(entityMapper::toDomain);
	}

	@Override
	public List<Carrito> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCarrito) {
		jpaRepositorio.deleteById(idCarrito);
	}
	
}
