package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;

public interface IComprobantesPagoRepositorio {
	ComprobantesPago guardar(ComprobantesPago nuevoComprobante);
	Optional<ComprobantesPago> buscarPorId(int idComprobante);
	List<ComprobantesPago> listarTodos();
	void eliminar(int idComprobante);
}