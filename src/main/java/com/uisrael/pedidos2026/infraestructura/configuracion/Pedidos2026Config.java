package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetallePedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CategoriaUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ComprobantesPagoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.DetallePedidosUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EntregasUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EstadosGeneralesUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.HistorialPedidosUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.PedidosUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ProductoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.UsuarioUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IDetallePedidosRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidosRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.CategoriaRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.DetallePedidosRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.HistorialPedidoRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.PedidosRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IDetallePedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IHistorialPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IDetallePedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IHistorialPedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;

@Configuration
public class Pedidos2026Config {
	
	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper mapper) {
		return new ProductoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IProductoUseCase productoUseCase(IProductoRepositorio repoUseCase) {
		return new ProductoUseCaseImpl(repoUseCase);
	}
	
	@Bean
	ICategoriaRepositorio categoriaRepositorio(ICategoriaJpaRepositorio jpaRepositorio, ICategoriaJpaMapper mapper) {
		return new CategoriaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICategoriaUseCase categoriaUseCase(ICategoriaRepositorio repoUseCase) {
		return new CategoriaUseCaseImpl(repoUseCase);
	}
	
	

	@Bean
	IPedidosRepositorio pedidosRepositorios(IPedidosJpaRepositorios jpaRepositorio, IPedidosJpaMapper mapper) {
		return new PedidosRepositoriosImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IPedidosUseCase pedidosUseCase(IPedidosRepositorio repoUsecase) {
		return new PedidosUseCaseImpl(repoUsecase);
	}
	

	@Bean
	IDetallePedidosRepositorio detallePedidosRepositorio(IDetallePedidosJpaRepositorios jpaRepositorios, IDetallePedidosJpaMapper mapper) {
		return new DetallePedidosRepositoriosImpl(jpaRepositorios, mapper);
	}
	
	@Bean
	IDetallePedidosUseCase detallePedidosUseCase(IDetallePedidosRepositorio repoUsecase) {	
		return new DetallePedidosUseCaseImpl(repoUsecase);
	}
	
	@Bean
	IHistorialPedidosRepositorio historialPedidosRepositorio(IHistorialPedidosJpaRepositorios jpaRepositorios,IHistorialPedidosJpaMapper mapper) {
		return new HistorialPedidoRepositoriosImpl(jpaRepositorios, mapper);
	}
	

	@Bean
	IHistorialPedidosUseCase historialPedidosUseCase(IHistorialPedidosRepositorio repoUsecase) {
		return new HistorialPedidosUseCaseImpl(repoUsecase);
	}

	
	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
		return new UsuarioUseCaseImpl(usuarioRepositorio);
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
