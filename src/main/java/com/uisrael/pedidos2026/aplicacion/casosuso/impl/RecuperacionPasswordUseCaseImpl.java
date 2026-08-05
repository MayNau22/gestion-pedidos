package com.uisrael.pedidos2026.aplicacion.casosuso.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IRecuperacionPasswordUseCase;
import com.uisrael.pedidos2026.aplicacion.servicios.ICorreoService;
import com.uisrael.pedidos2026.dominio.entidades.RecuperacionPassword;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IRecuperacionPasswordRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;

@Service
public class RecuperacionPasswordUseCaseImpl implements IRecuperacionPasswordUseCase {

	private final IUsuarioRepositorio usuarioRepositorio;

	private final IRecuperacionPasswordRepositorio recuperacionRepositorio;

	private final ICorreoService correoService;

	public RecuperacionPasswordUseCaseImpl(IUsuarioRepositorio usuarioRepositorio,
			IRecuperacionPasswordRepositorio recuperacionRepositorio, ICorreoService correoService) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
		this.recuperacionRepositorio = recuperacionRepositorio;
		this.correoService = correoService;
	}

	@Override
	public void solicitarRecuperacion(String correo) {

		Usuario usuario = usuarioRepositorio.buscarPorCorreo(correo)
				.orElseThrow(() -> new RuntimeException("El correo no existe"));

		String token = UUID.randomUUID().toString();

		RecuperacionPassword recuperacion = new RecuperacionPassword();

		recuperacion.setUsuario(usuario);

		recuperacion.setToken(token);

		recuperacion.setFechaCreacion(new Date());

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, 30);

		recuperacion.setFechaExpiracion(calendar.getTime());

		recuperacion.setUtilizado(false);

		recuperacionRepositorio.guardar(recuperacion);

		System.out.println("LINK DE RECUPERACION");
		System.out.println("http://localhost:8081/restablecer?token=" + token);

		String enlaceRecuperacion = "http://localhost:8081/auth/restablecer?token=" + token;

		correoService.enviarCorreoRecuperacion(usuario.getCorreo(), usuario.getNombre(), enlaceRecuperacion);

		System.out.println("Correo de recuperación enviado a: " + usuario.getCorreo());

	}

	@Override
	public boolean validarToken(String token) {

		if (token == null || token.isBlank()) {
			return false;
		}

		RecuperacionPassword recuperacion = recuperacionRepositorio.buscarPorToken(token.trim()).orElse(null);

		if (recuperacion == null) {
			return false;
		}

		if (recuperacion.isUtilizado()) {
			return false;
		}

		Date fechaExpiracion = recuperacion.getFechaExpiracion();

		if (fechaExpiracion == null) {
			return false;
		}

		Date fechaActual = new Date();

		return fechaExpiracion.after(fechaActual);
	}

	@Override
	public void restablecerPassword(String token, String nuevaContrasena, String confirmarContrasena) {

		if (token == null || token.isBlank()) {
			throw new RuntimeException("El token es obligatorio");
		}

		if (nuevaContrasena == null || nuevaContrasena.isBlank()) {

			throw new RuntimeException("La nueva contraseña es obligatoria");
		}

		if (nuevaContrasena.length() < 6) {

			throw new RuntimeException("La contraseña debe tener mínimo 6 caracteres");
		}

		if (!nuevaContrasena.equals(confirmarContrasena)) {

			throw new RuntimeException("Las contraseñas no coinciden");
		}

		RecuperacionPassword recuperacion = recuperacionRepositorio.buscarPorToken(token.trim())
				.orElseThrow(() -> new RuntimeException("El token no existe"));

		if (recuperacion.isUtilizado()) {

			throw new RuntimeException("El enlace de recuperación ya fue utilizado");
		}

		Date fechaActual = new Date();

		if (recuperacion.getFechaExpiracion() == null || !recuperacion.getFechaExpiracion().after(fechaActual)) {

			throw new RuntimeException("El enlace de recuperación ha expirado");
		}

		Usuario usuario = recuperacion.getUsuario();

		if (usuario == null) {

			throw new RuntimeException("No se encontró el usuario relacionado");
		}

		usuario.setContrasena(nuevaContrasena);

		usuarioRepositorio.actualizarContrasena(usuario.getIdUsuario(), nuevaContrasena);

		recuperacion.setUtilizado(true);

		recuperacionRepositorio.guardar(recuperacion);
	}

}