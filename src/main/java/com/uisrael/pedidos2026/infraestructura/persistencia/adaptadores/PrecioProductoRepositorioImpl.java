package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.PrecioProducto;
import com.uisrael.pedidos2026.dominio.repositorios.IPrecioProductoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PrecioProductoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPrecioProductoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;

public class PrecioProductoRepositorioImpl implements IPrecioProductoRepositorio {

	private final IPrecioProductoJpaRepositorio precioJpaRepositorio;
	private final IProductoJpaRepositorio productoJpaRepositorio;

	public PrecioProductoRepositorioImpl(IPrecioProductoJpaRepositorio precioJpaRepositorio,
			IProductoJpaRepositorio productoJpaRepositorio) {
		super();
		this.precioJpaRepositorio = precioJpaRepositorio;
		this.productoJpaRepositorio = productoJpaRepositorio;
	}

	@Override
	public PrecioProducto guardar(PrecioProducto precioProducto) {

		ProductoEntity producto = productoJpaRepositorio.findById(precioProducto.getIdProducto()).orElseThrow(
				() -> new RuntimeException("Producto no encontrado con ID: " + precioProducto.getIdProducto()));

		PrecioProductoEntity entity = new PrecioProductoEntity();

		entity.setIdPrecio(precioProducto.getIdPrecio());

		entity.setProducto(producto);
		entity.setPrecio(precioProducto.getPrecio());
		entity.setFechaInicio(precioProducto.getFechaInicio());
		entity.setFechaFin(precioProducto.getFechaFin());
		entity.setActivo(precioProducto.isActivo());

		if (precioProducto.isActivo()) {

			producto.setPrecio(precioProducto.getPrecio());

			productoJpaRepositorio.save(producto);
		}

		PrecioProductoEntity guardado = precioJpaRepositorio.save(entity);

		return mapToDomain(guardado);
	}

	@Override
	public Optional<PrecioProducto> buscarActivoPorProducto(int idProducto) {

		return precioJpaRepositorio.findFirstByProductoIdProductoAndActivoTrue(idProducto).map(this::mapToDomain);
	}

	@Override
	public List<PrecioProducto> listarPorProducto(int idProducto) {

		return precioJpaRepositorio.findByProductoIdProductoOrderByFechaInicioDesc(idProducto).stream()
				.map(this::mapToDomain).toList();
	}

	@Override
	public Optional<PrecioProducto> buscarPorId(int idPrecio) {

		return precioJpaRepositorio.findById(idPrecio).map(this::mapToDomain);
	}

	private PrecioProducto mapToDomain(PrecioProductoEntity entity) {

		PrecioProducto precio = new PrecioProducto();

		precio.setIdPrecio(entity.getIdPrecio());

		precio.setIdProducto(entity.getProducto().getIdProducto());

		precio.setNombreProducto(entity.getProducto().getNombre());

		precio.setPrecio(entity.getPrecio());
		precio.setFechaInicio(entity.getFechaInicio());
		precio.setFechaFin(entity.getFechaFin());
		precio.setActivo(entity.isActivo());

		return precio;
	}

}
