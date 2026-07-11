package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;

public interface IHistorialPedidoRepositorio {
	HistorialPedidos guardar(HistorialPedidos nuevoHistorial);
	Optional<HistorialPedidos> buscarPorId(int idHistorial);
	List<HistorialPedidos> listarTodos();
	void eliminar(int idHistorial);
}