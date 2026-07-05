package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorio;


public class PedidosRepositoriosImpl implements IPedidosRepositorio {
	
	private final IPedidosJpaRepositorio jpaRepositorio;
	private final IPedidosJpaMapper entityMapper;
	


	

	public PedidosRepositoriosImpl(IPedidosJpaRepositorio jpaRepositorio, IPedidosJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Pedidos guardar(Pedidos nuevoPedidos) {
		// TODO Auto-generated method stub
		PedidosEntity entity = entityMapper.toEntity(nuevoPedidos);
		PedidosEntity guardado= jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pedidos> buscarPorId(int idPedidos) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idPedidos).map(entityMapper:: toDomain);
	}

	@Override
	public List<Pedidos> listarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper:: toDomain).toList();
	}

	@Override
	public void eliminar(int idPedidos) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idPedidos);
	}
	
	
	
	

}
