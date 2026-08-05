package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.uisrael.pedidos2026.dominio.entidades.Rol;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.RolesEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioRolesEntity;
import com.uisrael.pedidos2026.infraestructura.repositorios.IRolesJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioJpaRepositorio;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioRolJpaRepositorio;

@Repository
public class UsuarioRepositorioImpl implements IUsuarioRepositorio {

	private final IUsuarioJpaRepositorio usuarioJpaRepositorio;
	private final IRolesJpaRepositorio rolesJpaRepositorio;
	private final IUsuarioRolJpaRepositorio usuarioRolesJpaRepositorio;

	public UsuarioRepositorioImpl(IUsuarioJpaRepositorio usuarioJpaRepositorio,
			IRolesJpaRepositorio rolesJpaRepositorio, IUsuarioRolJpaRepositorio usuarioRolesJpaRepositorio) {
		super();
		this.usuarioJpaRepositorio = usuarioJpaRepositorio;
		this.rolesJpaRepositorio = rolesJpaRepositorio;
		this.usuarioRolesJpaRepositorio = usuarioRolesJpaRepositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {

		UsuarioEntity entity = mapToEntity(nuevoUsuario);

		entity.setIdUsuario(0);
		entity.setEstado("true");
		entity.setFechaRegistro(new java.util.Date());

		UsuarioEntity usuarioGuardado = usuarioJpaRepositorio.save(entity);

		RolesEntity rolCliente = rolesJpaRepositorio.findByNombreIgnoreCase("CLIENTE")
				.orElseThrow(() -> new RuntimeException("No existe el rol CLIENTE"));

		UsuarioRolesEntity relacion = new UsuarioRolesEntity();

		relacion.setUsuarioRol(usuarioGuardado);
		relacion.setRol(rolCliente);

		usuarioRolesJpaRepositorio.save(relacion);

		return mapToDomain(usuarioGuardado);
	}

	@Override
	public Optional<Usuario> buscarPorId(int idUsuario) {

		return usuarioJpaRepositorio.findById(idUsuario).map(this::mapToDomain);
	}

	@Override
	public Optional<Usuario> buscarPorCorreo(String correo) {

		return usuarioJpaRepositorio.findByCorreo(correo).map(this::mapToDomain);
	}

	@Override
	public List<Usuario> listarTodos() {

		return usuarioJpaRepositorio.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
	}

	@Override
	public boolean existeCorreo(String correo) {

		return usuarioJpaRepositorio.existsByCorreo(correo);
	}

	@Override
	public boolean existeCedula(String cedula) {

		return usuarioJpaRepositorio.existsByCedula(cedula);
	}

	/*
	 * Eliminar ahora significa inactivar.
	 */
	@Override
	public void eliminar(int idUsuario) {

		UsuarioEntity usuario = usuarioJpaRepositorio.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

		usuario.setEstado("false");

		usuarioJpaRepositorio.save(usuario);
	}

	/*
	 * Activa nuevamente al usuario.
	 */
	@Override
	public void activar(int idUsuario) {

		UsuarioEntity usuario = usuarioJpaRepositorio.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

		usuario.setEstado("true");

		usuarioJpaRepositorio.save(usuario);
	}

	private UsuarioEntity mapToEntity(Usuario dominio) {

		if (dominio == null) {
			return null;
		}

		UsuarioEntity entity = new UsuarioEntity();

		entity.setIdUsuario(dominio.getIdUsuario());

		entity.setCedula(dominio.getCedula());

		entity.setNombre(dominio.getNombre());

		entity.setApellido(dominio.getApellido());

		entity.setCorreo(dominio.getCorreo());

		entity.setContrasena(dominio.getContrasena());

		entity.setCelular(dominio.getCelular());

		entity.setEstado(dominio.getEstado());

		entity.setFechaRegistro(dominio.getFechaRegistro());

		return entity;
	}

	private Usuario mapToDomain(UsuarioEntity entity) {

		if (entity == null) {
			return null;
		}

		List<Rol> roles = entity.getUsuariosroles().stream().map(usuarioRol -> {

			RolesEntity rolEntity = usuarioRol.getRol();

			return new Rol(rolEntity.getIdRol(), rolEntity.getNombre(), rolEntity.getDescripcion());
		}).toList();

		return new Usuario(entity.getIdUsuario(), entity.getCedula(), entity.getNombre(), entity.getApellido(),
				entity.getCorreo(), entity.getContrasena(), entity.getCelular(), entity.getEstado(),
				entity.getFechaRegistro(), roles);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {

		if (usuario == null) {
			throw new RuntimeException("El usuario no puede ser nulo");
		}

		if (usuario.getIdUsuario() <= 0) {
			throw new RuntimeException("El usuario debe tener un ID válido para actualizarse");
		}

		UsuarioEntity entityExistente = usuarioJpaRepositorio.findById(usuario.getIdUsuario())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuario.getIdUsuario()));

		entityExistente.setCedula(usuario.getCedula());
		entityExistente.setNombre(usuario.getNombre());
		entityExistente.setApellido(usuario.getApellido());
		entityExistente.setCorreo(usuario.getCorreo());
		entityExistente.setContrasena(usuario.getContrasena());
		entityExistente.setCelular(usuario.getCelular());
		entityExistente.setEstado(usuario.getEstado());
		entityExistente.setFechaRegistro(usuario.getFechaRegistro());

		UsuarioEntity guardado = usuarioJpaRepositorio.save(entityExistente);

		return mapToDomain(guardado);
	}

	@Override
	public Usuario actualizarContrasena(int idUsuario, String nuevaContrasena) {

		UsuarioEntity entity = usuarioJpaRepositorio.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

		entity.setContrasena(nuevaContrasena);

		UsuarioEntity guardado = usuarioJpaRepositorio.save(entity);

		return mapToDomain(guardado);
	}
}