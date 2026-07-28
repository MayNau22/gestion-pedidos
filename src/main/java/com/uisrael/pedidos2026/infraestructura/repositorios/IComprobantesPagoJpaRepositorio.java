package com.uisrael.pedidos2026.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ComprobantesPagoEntity;

public interface IComprobantesPagoJpaRepositorio extends JpaRepository<ComprobantesPagoEntity, Integer> {

	List<ComprobantesPagoEntity> findByPedidoComprobanteIdPedido(int idPedido);

	Optional<ComprobantesPagoEntity> findFirstByPedidoComprobanteIdPedidoOrderByFechaSubidaDesc(int idPedido);

	List<ComprobantesPagoEntity> findByPedidoComprobanteIdPedidoOrderByFechaSubidaDesc(int idPedido);
}
