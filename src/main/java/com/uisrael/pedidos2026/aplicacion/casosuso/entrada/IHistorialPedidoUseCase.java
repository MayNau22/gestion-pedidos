package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedidos;

public interface IHistorialPedidoUseCase {
	HistorialPedidos guardar(HistorialPedidos nuevoHistorial);
	HistorialPedidos buscarPorId(int idHistorial);
	List<HistorialPedidos> listarTodos();
	void eliminar(int idHistorial);
}