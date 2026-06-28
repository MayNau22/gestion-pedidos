package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.HistorialPedido;

public interface IHistorialPedidoUseCase {
	HistorialPedido guardar(HistorialPedido nuevoHistorial);
	HistorialPedido buscarPorId(int idHistorial);
	List<HistorialPedido> listarTodos();
	void eliminar(int idHistorial);
}