package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.uisrael.pedidos2026.dominio.entidades.DetallePedidos;
import com.uisrael.pedidos2026.dominio.entidades.Pedidos;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.EstadosGeneralesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.PedidosEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.pedidos2026.infraestructura.repositorios.IEstadosGeneralesJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioJpaRepositorio;

public class PedidosRepositoriosImpl implements IPedidosRepositorio {

	private final IPedidosJpaRepositorios pedidosJpaRepositorio;
	private final IUsuarioJpaRepositorio usuarioJpaRepositorio;
	private final IProductoJpaRepositorio productoJpaRepositorio;
	private final IEstadosGeneralesJpaRepositorio estadoJpaRepositorio;

	public PedidosRepositoriosImpl(IPedidosJpaRepositorios pedidosJpaRepositorio,
			IUsuarioJpaRepositorio usuarioJpaRepositorio, IProductoJpaRepositorio productoJpaRepositorio,
			IEstadosGeneralesJpaRepositorio estadoJpaRepositorio) {

		this.pedidosJpaRepositorio = pedidosJpaRepositorio;

		this.usuarioJpaRepositorio = usuarioJpaRepositorio;

		this.productoJpaRepositorio = productoJpaRepositorio;

		this.estadoJpaRepositorio = estadoJpaRepositorio;
	}

	@Override
	@Transactional
	public Pedidos guardar(Pedidos nuevoPedido) {

		UsuarioEntity usuario = usuarioJpaRepositorio.findById(nuevoPedido.getIdUsuario())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		EstadosGeneralesEntity estadoInicial = estadoJpaRepositorio
				.findByNombreIgnoreCaseAndTipoEstadoIgnoreCase("PENDIENTE DE CONFIRMACION", "PEDIDO")
				.orElseThrow(() -> new RuntimeException("No existe el estado inicial " + "PENDIENTE DE CONFIRMACION"));

		if (nuevoPedido.getDetalles() == null || nuevoPedido.getDetalles().isEmpty()) {

			throw new RuntimeException("El pedido debe contener al menos un producto");
		}

		PedidosEntity pedidoEntity = new PedidosEntity();

		pedidoEntity.setFechaPedido(new Date());

		pedidoEntity.setFechaEntrega(nuevoPedido.getFechaEntrega());

		pedidoEntity.setDireccionEntrega(nuevoPedido.getDireccionEntrega());

		pedidoEntity.setObservacion(nuevoPedido.getObservacion());

		pedidoEntity.setUsuarioPedido(usuario);

		pedidoEntity.setEstadoPedido(estadoInicial);

		double totalPedido = 0.0;

		for (DetallePedidos detalleDominio : nuevoPedido.getDetalles()) {

			ProductoEntity producto = productoJpaRepositorio.findById(detalleDominio.getIdProducto()).orElseThrow(
					() -> new RuntimeException("Producto no encontrado con ID: " + detalleDominio.getIdProducto()));

			if (!producto.isDisponible()) {

				throw new RuntimeException("El producto " + producto.getNombre() + " no está disponible");
			}

			if (detalleDominio.getCantidad() <= 0) {

				throw new RuntimeException(
						"La cantidad del producto " + producto.getNombre() + " debe ser mayor que cero");
			}

			if (detalleDominio.getCantidad() > producto.getStock()) {

				throw new RuntimeException("Stock insuficiente para " + producto.getNombre());
			}

			double precioUnitario = producto.getPrecio();

			double subtotal = precioUnitario * detalleDominio.getCantidad();

			DetallePedidoEntity detalleEntity = new DetallePedidoEntity();

			detalleEntity.setPedido(pedidoEntity);
			detalleEntity.setProducto(producto);

			detalleEntity.setCantidad(detalleDominio.getCantidad());

			detalleEntity.setPrecioUnitario(precioUnitario);

			detalleEntity.setSubtotal(subtotal);

			pedidoEntity.getDetallePedido().add(detalleEntity);

			totalPedido += subtotal;

			producto.setStock(producto.getStock() - detalleDominio.getCantidad());

			productoJpaRepositorio.save(producto);
		}

		pedidoEntity.setTotal(totalPedido);

		PedidosEntity guardado = pedidosJpaRepositorio.save(pedidoEntity);

		return convertirADominio(guardado);
	}

	@Override
	public Optional<Pedidos> buscarPorId(int idPedido) {

		return pedidosJpaRepositorio.findById(idPedido).map(this::convertirADominio);
	}

	@Override
	public List<Pedidos> listarTodos() {

		return pedidosJpaRepositorio.findAll().stream().map(this::convertirADominio).toList();
	}

	@Override
	public void eliminar(int idPedido) {

		pedidosJpaRepositorio.deleteById(idPedido);
	}

	private Pedidos convertirADominio(PedidosEntity entity) {

		Pedidos pedido = new Pedidos();

		pedido.setIdPedido(entity.getIdPedido());

		pedido.setIdUsuario(entity.getUsuarioPedido() != null ? entity.getUsuarioPedido().getIdUsuario() : 0);

		if (entity.getUsuarioPedido() != null) {

			pedido.setNombreCliente(entity.getUsuarioPedido().getNombre());

			pedido.setCelularCliente(entity.getUsuarioPedido().getCelular());
		}

		pedido.setIdEstado(entity.getEstadoPedido() != null ? entity.getEstadoPedido().getIdEstado() : 0);

		pedido.setFechaPedido(entity.getFechaPedido());

		pedido.setFechaEntrega(entity.getFechaEntrega());

		pedido.setDireccionEntrega(entity.getDireccionEntrega());

		pedido.setObservacion(entity.getObservacion());

		pedido.setTotal(entity.getTotal());

		List<DetallePedidos> detalles;

		if (entity.getDetallePedido() == null) {

			detalles = List.of();

		} else {

			detalles = entity.getDetallePedido().stream().map(detalleEntity -> {

				DetallePedidos detalle = new DetallePedidos();

				detalle.setIdDetallePedido(detalleEntity.getIdDetallePedido());

				detalle.setIdPedido(entity.getIdPedido());

				detalle.setIdProducto(
						detalleEntity.getProducto() != null ? detalleEntity.getProducto().getIdProducto() : 0);

				detalle.setCantidad(detalleEntity.getCantidad());

				detalle.setPrecioUnitario(detalleEntity.getPrecioUnitario());

				detalle.setSubtotal(detalleEntity.getSubtotal());

				return detalle;
			}).toList();
		}

		pedido.setDetalles(detalles);

		return pedido;
	}

	@Override
	public List<Pedidos> listarPorUsuario(int idUsuario) {

		return pedidosJpaRepositorio.findByUsuarioPedidoIdUsuario(idUsuario).stream().map(this::convertirADominio)
				.toList();
	}
}