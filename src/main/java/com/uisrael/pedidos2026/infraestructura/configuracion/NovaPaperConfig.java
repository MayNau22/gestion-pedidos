package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetallePedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.DetallePedidosUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.HistorialPedidosUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.PedidosUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.IDetallePedidosRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidosRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.DetallePedidosRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.HistorialPedidoRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.PedidosRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IDetallePedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IHistorialPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IDetallePedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IHistorialPedidosJpaRepositorios;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorios;

@Configuration
public class NovaPaperConfig {

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
	IHistorialPedidoRepositorio historialPedidosRepositorio(IHistorialPedidosJpaRepositorios jpaRepositorios,IHistorialPedidosJpaMapper mapper) {
		return new HistorialPedidoRepositoriosImpl(jpaRepositorios, mapper);
	}
	

	@Bean
	IHistorialPedidosUseCase historialPedidosUseCase(IHistorialPedidosRepositorio repoUsecase) {
		return new HistorialPedidosUseCaseImpl(repoUsecase);
	}
	
}
