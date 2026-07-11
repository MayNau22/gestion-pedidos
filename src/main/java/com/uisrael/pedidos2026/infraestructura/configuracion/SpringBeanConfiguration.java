package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Casos de uso (Interfaces de entrada)
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICarritoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;

// Implementaciones
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CarritoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ComprobantesPagoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EntregasUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EstadosGeneralesUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.HistorialPedidoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.UsuarioUseCaseImpl;

// Repositorios del Dominio
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IUsuarioRolJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioJpaReposito;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioRolJpaRepositorio;

@Configuration
public class SpringBeanConfiguration {

	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
		return new UsuarioUseCaseImpl(usuarioRepositorio);
	}
	
	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaReposito jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	ICarritoUseCase carritoUseCase(ICarritoRepositorio carritoRepositorio) {
		return new CarritoUseCaseImpl(carritoRepositorio);
	}

	@Bean
	IHistorialPedidoUseCase historialPedidoUseCase(IHistorialPedidoRepositorio historialPedidoRepositorio) {
		return new HistorialPedidoUseCaseImpl(historialPedidoRepositorio);
	}

	@Bean
	IEstadosGeneralesUseCase estadosGeneralesUseCase(IEstadosGeneralesRepositorio estadosGeneralesRepositorio) {
		return new EstadosGeneralesUseCaseImpl(estadosGeneralesRepositorio);
	}

	@Bean
	IEntregasUseCase entregasUseCase(IEntregasRepositorio entregasRepositorio) {
		return new EntregasUseCaseImpl(entregasRepositorio);
	}

	@Bean
	IComprobantesPagoUseCase comprobantesPagoUseCase(IComprobantesPagoRepositorio comprobantesPagoRepositorio) {
		return new ComprobantesPagoUseCaseImpl(comprobantesPagoRepositorio);
	}

}