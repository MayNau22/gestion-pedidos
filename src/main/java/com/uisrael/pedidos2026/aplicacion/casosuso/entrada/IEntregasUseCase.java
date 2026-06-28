package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;

public interface IEntregasUseCase {
	Entregas guardar(Entregas nuevaEntrega);
	Entregas buscarPorId(int idEntrega);
	List<Entregas> listarTodos();
	void eliminar(int idEntrega);
}