package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

import java.util.List;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;

public interface IUsuarioUseCase {
	Usuario guardar(Usuario nuevoUsuario);
	Usuario buscarPorId(int idUsuario);
	List<Usuario> listarTodos();
	void eliminar(int idUsuario);
}