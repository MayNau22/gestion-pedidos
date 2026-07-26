package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;

public interface IPedidosRepositorio {
	Pedidos guardar(Pedidos nuevoPedidos);
	Optional<Pedidos> buscarPorId(int idPedidos);
	List<Pedidos> listarTodos();
	void eliminar (int idPedidos);

}
