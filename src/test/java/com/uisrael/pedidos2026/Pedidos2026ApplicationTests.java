package com.uisrael.pedidos2026;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.pedidos2026.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IProductoJpaRepositorio;

@SpringBootTest
class Pedidos2026ApplicationTests {
	
	@Autowired
	IProductoJpaRepositorio repoProducto;
	
	@Autowired
	ICategoriaJpaRepositorio repoCategoria;

	@Test
	void contextLoads() {
		
		ProductoEntity nuevo = new ProductoEntity();
		nuevo.setNombre("Nuevo");
		nuevo.setDescripcion("Nuevo descripcion");
		repoProducto.save(nuevo);
		
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setNombre("Nuevo");
		categoria.setDescripcion("Nueva categoria");
		repoCategoria.save(categoria);
	}

}
