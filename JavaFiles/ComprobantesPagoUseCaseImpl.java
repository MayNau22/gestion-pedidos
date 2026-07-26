package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;

public class ComprobantesPagoUseCaseImpl implements IComprobantesPagoUseCase {

	private final IComprobantesPagoRepositorio repositorio;

	public ComprobantesPagoUseCaseImpl(IComprobantesPagoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ComprobantesPago guardar(ComprobantesPago nuevoComprobante) {
		return repositorio.guardar(nuevoComprobante);
	}

	@Override
	public ComprobantesPago buscarPorId(int idComprobante) {
		return repositorio.buscarPorId(idComprobante)
				.orElseThrow(() -> new RuntimeException("Comprobante de pago no encontrado"));
	}

	@Override
	public List<ComprobantesPago> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idComprobante) {
		repositorio.eliminar(idComprobante);
	}
}





