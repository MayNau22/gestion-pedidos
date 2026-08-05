package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IRecuperacionPasswordUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.presentacion.dto.request.LoginRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.request.RestablecerPasswordRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.request.SolicitarRecuperacionRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.request.UsuarioRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.UsuarioResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private final IUsuarioUseCase usuarioUseCase;
	private final IUsuarioDtoMapper mapper;
	private final IRecuperacionPasswordUseCase recuperacionPasswordUseCase;

	public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper,
			IRecuperacionPasswordUseCase recuperacionPasswordUseCase) {
		super();
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
		this.recuperacionPasswordUseCase = recuperacionPasswordUseCase;
	}

	@PostMapping("/registro")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto registrar(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {

		Usuario usuario = mapper.toDomain(usuarioRequestDto);

		Usuario usuarioGuardado = usuarioUseCase.guardar(usuario);

		return mapper.toResponseDto(usuarioGuardado);
	}

	@GetMapping
	public List<UsuarioResponseDto> listarTodos() {

		return usuarioUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/id/{idUsuario}")
	public UsuarioResponseDto buscarPorId(@PathVariable int idUsuario) {

		Usuario usuario = usuarioUseCase.buscarPorId(idUsuario);

		return mapper.toResponseDto(usuario);
	}

	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> eliminar(@PathVariable int idUsuario) {

		usuarioUseCase.eliminar(idUsuario);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/activar/{idUsuario}")
	public ResponseEntity<Void> activar(@PathVariable int idUsuario) {

		usuarioUseCase.activar(idUsuario);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public UsuarioResponseDto login(@RequestBody LoginRequestDto loginDto) {

		return mapper.toResponseDto(usuarioUseCase.login(loginDto.getCorreo(), loginDto.getContrasena()));
	}

	@PostMapping("/recuperar-password")
	public ResponseEntity<?> recuperarPassword(

			@Valid @RequestBody SolicitarRecuperacionRequestDto dto) {

		recuperacionPasswordUseCase.solicitarRecuperacion(dto.getCorreo());

		return ResponseEntity.ok("Se generó el enlace de recuperación");
	}

	@GetMapping("/validar-token/{token}")
	public ResponseEntity<?> validarToken(@PathVariable String token) {

		boolean valido = recuperacionPasswordUseCase.validarToken(token);

		if (!valido) {

			return ResponseEntity.badRequest().body("El token es inválido, expiró o ya fue utilizado");
		}

		return ResponseEntity.ok("El token es válido");
	}

	@PostMapping("/restablecer-password")
	public ResponseEntity<?> restablecerPassword(@Valid @RequestBody RestablecerPasswordRequestDto dto) {

		recuperacionPasswordUseCase.restablecerPassword(dto.getToken(), dto.getNuevaContrasena(),
				dto.getConfirmarContrasena());

		return ResponseEntity.ok("La contraseña fue actualizada correctamente");
	}
}