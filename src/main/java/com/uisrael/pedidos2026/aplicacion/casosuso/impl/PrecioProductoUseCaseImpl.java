package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPrecioProductoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.PrecioProducto;
import com.uisrael.pedidos2026.dominio.repositorios.IPrecioProductoRepositorio;

public class PrecioProductoUseCaseImpl implements IPrecioProductoUseCase {
	private final IPrecioProductoRepositorio repositorio;

	public PrecioProductoUseCaseImpl(IPrecioProductoRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	@Transactional
	public PrecioProducto registrarPrecio(int idProducto, Double nuevoPrecio) {

		if (idProducto <= 0) {
			throw new RuntimeException("El producto es obligatorio");
		}

		if (nuevoPrecio == null || nuevoPrecio <= 0) {
			throw new RuntimeException("El precio debe ser mayor que cero");
		}

		Date fechaActual = new Date();

		Optional<PrecioProducto> precioActual = repositorio.buscarActivoPorProducto(idProducto);

		if (precioActual.isPresent()) {

			PrecioProducto anterior = precioActual.get();

			if (Double.compare(anterior.getPrecio(), nuevoPrecio) == 0) {

				return anterior;
			}

			anterior.setActivo(false);
			anterior.setFechaFin(fechaActual);

			repositorio.guardar(anterior);
		}

		PrecioProducto nuevo = new PrecioProducto();

		nuevo.setIdProducto(idProducto);
		nuevo.setPrecio(nuevoPrecio);
		nuevo.setFechaInicio(fechaActual);
		nuevo.setFechaFin(null);
		nuevo.setActivo(true);

		return repositorio.guardar(nuevo);
	}

	@Override
	public PrecioProducto obtenerPrecioActivo(int idProducto) {

		return repositorio.buscarActivoPorProducto(idProducto)
				.orElseThrow(() -> new RuntimeException("El producto no tiene un precio activo"));
	}

	@Override
	public List<PrecioProducto> listarHistorial(int idProducto) {

		return repositorio.listarPorProducto(idProducto);
	}
}
