package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;

public interface IPedidosUseCase {
	
	Pedidos guardar(Pedidos nuevopedidos);
	Pedidos buscarPorId(int idPedidos);
	List<Pedidos> listarTodos();
	void eliminar (int idPedidos);

}
