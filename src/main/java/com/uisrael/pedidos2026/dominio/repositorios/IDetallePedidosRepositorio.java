package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedido;

public interface IDetallePedidosRepositorio {
	DetallePedido guardar(DetallePedido nuevoDetallePedido);
	Optional<DetallePedido> buscarPorId(int IdDetallePedido);
	List<DetallePedido> listarTodos();
	void eliminar (int idGrupo);

}
