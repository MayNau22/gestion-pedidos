package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EntregasEntity;

public interface IEntregasJpaRepositorio extends JpaRepository<EntregasEntity, Integer> {

	boolean existsByPedidoEntregaIdPedido(int idPedido);

	Optional<EntregasEntity> findByPedidoEntregaIdPedido(int idPedido);

	List<EntregasEntity> findByEstadoEntregaIdEstadoInOrderByPedidoEntregaFechaEntregaAsc(List<Integer> idsEstado);
}