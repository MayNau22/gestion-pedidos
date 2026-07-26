package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IEntregasJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEntregasJpaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EntregasRepositorioImpl implements IEntregasRepositorio {

    @Autowired
    private IEntregasJpaRepositorio jpaRepositorio;

    @Autowired
    private IEntregasJpaMapper mapper;

    @Override
    public Entregas guardar(Entregas entregas) {
        EntregasEntity entity = mapper.toEntity(entregas);
        EntregasEntity guardado = jpaRepositorio.save(entity);
        return mapper.toDomain(guardado);
    }

    @Override
    public Optional<Entregas> buscarPorId(int idEntrega) {
        return jpaRepositorio.findById(idEntrega)
                .map(mapper::toDomain);
    }

    @Override
    public List<Entregas> listarTodos() {
        List<EntregasEntity> entidades = jpaRepositorio.findAll();
        return mapper.toDomainList(entidades);
    }

    @Override
    public void eliminar(int idEntrega) {
        jpaRepositorio.deleteById(idEntrega);
    }
}