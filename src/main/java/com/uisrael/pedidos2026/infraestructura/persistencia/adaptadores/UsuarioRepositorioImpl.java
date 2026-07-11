package com.uisrael.pedidos2026.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.uisrael.pedidos2026.infraestructura.repositorios.IUsuarioJpaRepositorio;

@Repository 
public class UsuarioRepositorioImpl implements IUsuarioRepositorio {

    private final IUsuarioJpaRepositorio usuarioJpaRepositorio;

    public UsuarioRepositorioImpl(IUsuarioJpaRepositorio usuarioJpaRepositorio) {
        this.usuarioJpaRepositorio = usuarioJpaRepositorio;
    }

    @Override
    public Usuario guardar(Usuario nuevoUsuario) {
        UsuarioEntity entity = mapToEntity(nuevoUsuario);
        UsuarioEntity guardado = usuarioJpaRepositorio.save(entity);
        return mapToDomain(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorId(int idUsuario) {
        return usuarioJpaRepositorio.findById(idUsuario)
                .map(this::mapToDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioJpaRepositorio.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int idUsuario) {
        usuarioJpaRepositorio.deleteById(idUsuario);
    }

    
    private UsuarioEntity mapToEntity(Usuario dominio) {
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
        return new Usuario(
            entity.getIdUsuario(),
            entity.getCedula(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getCorreo(),
            entity.getContrasena(),
            entity.getCelular(),
            entity.getEstado(),
            entity.getFechaRegistro()
        );
    }
}

