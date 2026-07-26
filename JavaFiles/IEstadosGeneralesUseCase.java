package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;

public interface IEstadosGeneralesUseCase {
	EstadosGenerales guardar(EstadosGenerales nuevoEstado);
	EstadosGenerales buscarPorId(int idEstado);
	List<EstadosGenerales> listarTodos();
	void eliminar(int idEstado);
}