package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;

public interface IEntregasUseCase {
	Entregas guardar(Entregas nuevaEntrega);

	Entregas buscarPorId(int idEntrega);

	Entregas buscarPorPedido(int idPedido);

	List<Entregas> listarTodos();

	List<Entregas> listarActivas();

	void eliminar(int idEntrega);

	Entregas cambiarEstado(int idEntrega, int idEstado, String observacion);

	Entregas finalizarEntrega(int idEntrega, MultipartFile evidencia, String recibidoPor, String observacion);
}