package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.PedidosUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.IPedidosRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.PedidosRepositoriosImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IPedidosJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.IPedidosJpaRepositorio;

@Configuration
public class gestion2026 {
	
	@Bean
	IPedidosRepositorio pedidosRepositorio(IPedidosJpaRepositorio jpaRepositorio, IPedidosJpaMapper mapper) {
		return new PedidosRepositoriosImpl(jpaRepositorio, mapper);
		
	}
	
	@Bean
	IPedidosUseCase pedidosUseCase(IPedidosRepositorio repoUsecase) {
		return new PedidosUseCaseImpl(repoUsecase);
		
	}

}
