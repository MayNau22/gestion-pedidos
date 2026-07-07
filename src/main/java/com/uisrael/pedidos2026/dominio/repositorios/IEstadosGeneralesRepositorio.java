package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;

public interface IEstadosGeneralesRepositorio {
	EstadosGenerales guardar(EstadosGenerales nuevoEstado);
	Optional<EstadosGenerales> buscarPorId(int idEstado);
	List<EstadosGenerales> listarTodos();
	void eliminar(int idEstado);
}