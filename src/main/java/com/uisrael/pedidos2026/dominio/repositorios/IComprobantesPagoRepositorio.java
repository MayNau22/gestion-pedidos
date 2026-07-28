package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;

public interface IComprobantesPagoRepositorio {
	ComprobantesPago guardar(ComprobantesPago nuevoComprobante);

	ComprobantesPago guardarArchivo(int idPedido, MultipartFile archivo, String tipoPago, Double monto,
			String observacion);

	Optional<ComprobantesPago> buscarPorId(int idComprobante);

	Optional<ComprobantesPago> buscarPorPedido(int idPedido);

	List<ComprobantesPago> listarTodos();

	void eliminar(int idComprobante);

	List<ComprobantesPago> listarPorPedido(int idPedido);

	ComprobantesPago cambiarEstado(int idComprobante, int idEstado, String observacion);
}