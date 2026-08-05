package com.uisrael.pedidos2026.aplicacion.servicios;

public interface ICorreoService {
	
	void enviarCorreoRecuperacion(String destinatario, String nombreUsuario, String enlaceRecuperacion);
}
