package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.PrecioProducto;

public interface IPrecioProductoRepositorio {

	PrecioProducto guardar(PrecioProducto precioProducto);

	Optional<PrecioProducto> buscarActivoPorProducto(int idProducto);

	List<PrecioProducto> listarPorProducto(int idProducto);

	Optional<PrecioProducto> buscarPorId(int idPrecio);

}
