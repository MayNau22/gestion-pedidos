package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedido;

public interface IDetallePedidoUseCase {
	
	DetallePedido guardar(DetallePedido nuevoDetallePedido);
	DetallePedido buscarPorId(int idDetallePedido);
	List<DetallePedido> listarTodos();
	void eliminar (int idDetallePedido);

}
