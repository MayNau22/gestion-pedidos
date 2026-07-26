package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;

public interface IEntregasRepositorio {
	Entregas guardar(Entregas nuevaEntrega);
	Optional<Entregas> buscarPorId(int idEntrega);
	List<Entregas> listarTodos();
	void eliminar(int idEntrega);
}