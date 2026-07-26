package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;

public interface IDetallePedidosUseCase {
	
	DetallePedidos guardar(DetallePedidos nuevoDestallePedidos);
	DetallePedidos buscarPorId(int idDestallePedidos);
	List<DetallePedidos> listarTodos();
	void eliminar (int idDestallePedidos);

}
