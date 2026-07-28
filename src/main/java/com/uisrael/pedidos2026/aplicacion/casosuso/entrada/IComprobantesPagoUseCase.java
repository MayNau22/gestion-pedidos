package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;

public interface IComprobantesPagoUseCase {
	ComprobantesPago guardar(ComprobantesPago nuevoComprobante);

	ComprobantesPago buscarPorId(int idComprobante);

	List<ComprobantesPago> listarTodos();

	void eliminar(int idComprobante);

	Optional<ComprobantesPago> buscarPorPedido(int idPedido);

	ComprobantesPago guardarArchivo(int idPedido, MultipartFile archivo, String tipoPago, Double monto,
			String observacion);
}