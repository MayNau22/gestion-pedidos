package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CategoriaUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ProductoUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.CategoriaRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICategoriaJpaRepositorio;
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
	

}
