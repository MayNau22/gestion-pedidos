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
		CategoriaEntity categoria = jpaRepositorio
	            .findById(idCategoria)
	            .orElseThrow(() ->
	                    new RuntimeException(
	                            "Categoría no encontrada."
	                    ));

	    categoria.setEstado(false);

	    jpaRepositorio.save(categoria);
		
	}
	
	@Override
	public void activar(int idCategoria) {

	    CategoriaEntity categoria = jpaRepositorio
	            .findById(idCategoria)
	            .orElseThrow(() ->
	                    new RuntimeException(
	                            "Categoría no encontrada."
	                    ));

	    categoria.setEstado(true);

	    jpaRepositorio.save(categoria);
	}

	@Override
	public Categoria actualizar(Categoria categoria) {
		 CategoriaEntity existente = jpaRepositorio
		            .findById(categoria.getIdCategoria())
		            .orElseThrow(() ->
		                    new RuntimeException(
		                            "Categoría no encontrada con ID: "
		                            + categoria.getIdCategoria()
		                    )
		            );

		    existente.setNombre(categoria.getNombre());
		    existente.setDescripcion(categoria.getDescripcion());
		    
		    CategoriaEntity actualizada =
		            jpaRepositorio.save(existente);

		    return entityMapper.toDomain(actualizada);
	}
	
}
