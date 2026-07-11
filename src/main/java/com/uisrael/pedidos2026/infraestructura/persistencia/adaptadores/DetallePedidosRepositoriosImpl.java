package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IDetallePedidosRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IDetallePedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IDetallePedidosJpaRepositorios;

public class DetallePedidosRepositoriosImpl implements IDetallePedidosRepositorio {
	
	private final IDetallePedidosJpaRepositorios jpaRepositorio;
	private final IDetallePedidosJpaMapper entityMapper;
	
	public DetallePedidosRepositoriosImpl(IDetallePedidosJpaRepositorios jpaRepositorio,
			IDetallePedidosJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetallePedidos guardar(DetallePedidos nuevoDestallePedidos) {
		DetallePedidoEntity entity=entityMapper.toEntity(nuevoDestallePedidos);
		DetallePedidoEntity guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetallePedidos> buscarPorId(int idDestallePedidos) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDestallePedidos).map(entityMapper::toDomain);
	}

	@Override
	public List<DetallePedidos> listarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDestallePedidos) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDestallePedidos);
		
	}


	
	
	
	
	

	

}
