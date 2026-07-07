package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository; // <-- IMPORTANTE
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IComprobantesPagoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IComprobantesPagoJpaRepositorio;

@Repository 
public class ComprobantesPagoRepositorioImpl implements IComprobantesPagoRepositorio {

	private final IComprobantesPagoJpaRepositorio jpaRepositorio;
	private final IComprobantesPagoJpaMapper entityMapper;

	public ComprobantesPagoRepositorioImpl(IComprobantesPagoJpaRepositorio jpaRepositorio, IComprobantesPagoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ComprobantesPago guardar(ComprobantesPago nuevoComprobante) {
		ComprobantesPagoEntity entity = entityMapper.toEntity(nuevoComprobante);
		ComprobantesPagoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ComprobantesPago> buscarPorId(int idComprobante) {
		return jpaRepositorio.findById(idComprobante).map(entityMapper::toDomain);
	}

	@Override
	public List<ComprobantesPago> listarTodos() {
		return jpaRepositorio.findAll().stream()
				.map(entityMapper::toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idComprobante) {
		jpaRepositorio.deleteById(idComprobante);
	}
}