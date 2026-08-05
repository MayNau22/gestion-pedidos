package com.uisrael.pedidos2026.aplicacion.casosuso.entrada;

public interface IRecuperacionPasswordUseCase {

	void solicitarRecuperacion(String correo);

	boolean validarToken(String token);

	void restablecerPassword(String token, String nuevaContrasena, String confirmarContrasena);
}
