package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;

public interface IComprobantesPagoUseCase {
	ComprobantesPago guardar(ComprobantesPago nuevoComprobante);
	ComprobantesPago buscarPorId(int idComprobante);
	List<ComprobantesPago> listarTodos();
	void eliminar(int idComprobante);
}