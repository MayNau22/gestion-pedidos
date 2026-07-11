package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;

public interface IDetallePedidosRepositorio {
	DetallePedidos guardar(DetallePedidos nuevoDetallePedido);
	Optional<DetallePedidos> buscarPorId(int IdDetallePedido);
	List<DetallePedidos> listarTodos();
	void eliminar (int IdDetallePedido);

}
