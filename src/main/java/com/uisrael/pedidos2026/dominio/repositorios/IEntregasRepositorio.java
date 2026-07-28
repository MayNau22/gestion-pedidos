package com.uisrael.pedidos2026.dominio.repositorios;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface IEntregasRepositorio {
	Entregas guardar(Entregas nuevaEntrega);

	Optional<Entregas> buscarPorId(int idEntrega);

	Optional<Entregas> buscarPorPedido(int idPedido);

	List<Entregas> listarTodos();

	List<Entregas> listarActivas();

	boolean existePorPedido(int idPedido);

	void eliminar(int idEntrega);

	Entregas cambiarEstado(int idEntrega, int idEstado, String observacion);

	Entregas finalizarEntrega(int idEntrega, MultipartFile evidencia, String recibidoPor, String observacion);
}
