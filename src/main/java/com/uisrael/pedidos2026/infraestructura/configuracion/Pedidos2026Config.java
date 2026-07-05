package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICarritoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetalleCarritoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CarritoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CategoriaUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.DetalleCarritoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ProductoUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IDetalleCarritoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IProductoRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.CarritoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.CategoriaRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.DetalleCarritoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICarritoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IDetalleCarritoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICarritoJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IDetalleCarritoJpaRepositorio;
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
	ICarritoRepositorio carritoRepositorio(ICarritoJpaRepositorio jpaRepositorio, ICarritoJpaMapper mapper) {
		return new CarritoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICarritoUseCase carritoUseCae(ICarritoRepositorio repoUseCase) {
		return new CarritoUseCaseImpl(repoUseCase);
	}
	
	@Bean
	IDetalleCarritoRepositorio detalleCarritoRepositorio(IDetalleCarritoJpaRepositorio jpaRepositorio, IDetalleCarritoJpaMapper mapper) {
		return new DetalleCarritoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IDetalleCarritoUseCase detalleCarritoUseCae(IDetalleCarritoRepositorio repoUseCase) {
		return new DetalleCarritoUseCaseImpl(repoUseCase);
	}
	

}
