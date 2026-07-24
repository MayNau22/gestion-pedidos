package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio {

	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;

	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		ProductoEntity entity = entityMapper.toEntity(nuevoProducto);
		ProductoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Producto> buscarId(int idProducto) {

		return jpaRepositorio.findById(idProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listarProductos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProducto) {
		ProductoEntity producto = jpaRepositorio.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		producto.setDisponible(false);

		jpaRepositorio.save(producto);
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		return jpaRepositorio.findByNombre(nombre).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void activar(int idProducto) {
		ProductoEntity producto = jpaRepositorio.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		producto.setDisponible(true);

		jpaRepositorio.save(producto);

	}

	@Override
	public Producto actualizar(Producto producto) {
		ProductoEntity existente = jpaRepositorio.findById(producto.getIdProducto())
				.orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + producto.getIdProducto()));

		existente.setNombre(producto.getNombre());
		existente.setDescripcion(producto.getDescripcion());
		existente.setPrecio(producto.getPrecio());
		existente.setStock(producto.getStock());

		if (producto.getImagenUrl() != null && !producto.getImagenUrl().isBlank()) {

			existente.setImagenUrl(producto.getImagenUrl());
		}

		if (producto.getCategoria() != null) {

			CategoriaEntity categoria = new CategoriaEntity();

			categoria.setIdCategoria(producto.getCategoria().getIdCategoria());

			existente.setCategoria(categoria);
		}

		ProductoEntity actualizado = jpaRepositorio.save(existente);

		return entityMapper.toDomain(actualizado);
	}

}
