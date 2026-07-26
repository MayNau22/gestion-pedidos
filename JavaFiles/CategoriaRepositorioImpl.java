package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICategoriaJpaRepositorio;


public class CategoriaRepositorioImpl implements ICategoriaRepositorio{
	
	private final ICategoriaJpaRepositorio jpaRepositorio;
	private final ICategoriaJpaMapper entityMapper;
	
	public CategoriaRepositorioImpl(ICategoriaJpaRepositorio jpaRepositorio, ICategoriaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Categoria guardar(Categoria nuevaCateogoria) {
		CategoriaEntity entity = entityMapper.toEntity(nuevaCateogoria);
		CategoriaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Categoria> buscarId(int idCategoria) {
		return jpaRepositorio.findById(idCategoria).map(entityMapper::toDomain);
	}

	@Override
	public List<Categoria> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCategoria) {
		jpaRepositorio.deleteById(idCategoria);	
		
	}
	

}
