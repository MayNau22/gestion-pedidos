package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.Carrito;

public interface ICarritoUseCase {
	Carrito guardar(Carrito nuevoCarrito);
	Carrito buscarPorId(int idCarrito);
	List<Carrito> listarTodos();
	void eliminar(int idCarrito);
}