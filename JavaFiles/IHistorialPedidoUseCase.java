package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;

public interface IHistorialPedidoUseCase {

	HistorialPedidos guardar(HistorialPedidos nuevoHistorialPedidos);
	HistorialPedidos buscarPorId(int idHistorialPedidos);
	List<HistorialPedidos> listarTodos();
	void eliminar (int idHistorialPedidos);
}
