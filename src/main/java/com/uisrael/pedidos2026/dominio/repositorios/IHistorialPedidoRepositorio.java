package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedido;

public interface IHistorialPedidoRepositorio {
	HistorialPedido guardar(HistorialPedido nuevoHistorial);
	Optional<HistorialPedido> buscarPorId(int idHistorial);
	List<HistorialPedido> listarTodos();
	void eliminar(int idHistorial);
}