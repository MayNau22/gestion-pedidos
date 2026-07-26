package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;

public class EstadosGeneralesUseCaseImpl implements IEstadosGeneralesUseCase {

	private final IEstadosGeneralesRepositorio repositorio;

	public EstadosGeneralesUseCaseImpl(IEstadosGeneralesRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EstadosGenerales guardar(EstadosGenerales nuevoEstado) {
		return repositorio.guardar(nuevoEstado);
	}

	@Override
	public EstadosGenerales buscarPorId(int idEstado) {
		return repositorio.buscarPorId(idEstado)
				.orElseThrow(() -> new RuntimeException("Estado general no encontrado"));
	}

	@Override
	public List<EstadosGenerales> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEstado) {
		repositorio.eliminar(idEstado);
	}
}