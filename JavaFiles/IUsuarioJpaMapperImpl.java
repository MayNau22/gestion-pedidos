package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Usuario;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:16-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IUsuarioJpaMapperImpl implements IUsuarioJpaMapper {

    @Override
    public Usuario toDomain(UsuarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setIdUsuario( entity.getIdUsuario() );
        usuario.setCedula( entity.getCedula() );
        usuario.setNombre( entity.getNombre() );
        usuario.setApellido( entity.getApellido() );
        usuario.setCorreo( entity.getCorreo() );
        usuario.setContrasena( entity.getContrasena() );
        usuario.setCelular( entity.getCelular() );
        usuario.setEstado( entity.getEstado() );
        usuario.setFechaRegistro( entity.getFechaRegistro() );

        return usuario;
    }

    @Override
    public UsuarioEntity toEntity(Usuario usuarioPojo) {
        if ( usuarioPojo == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setApellido( usuarioPojo.getApellido() );
        usuarioEntity.setCedula( usuarioPojo.getCedula() );
        usuarioEntity.setCelular( usuarioPojo.getCelular() );
        usuarioEntity.setContrasena( usuarioPojo.getContrasena() );
        usuarioEntity.setCorreo( usuarioPojo.getCorreo() );
        usuarioEntity.setEstado( usuarioPojo.getEstado() );
        usuarioEntity.setFechaRegistro( usuarioPojo.getFechaRegistro() );
        usuarioEntity.setIdUsuario( usuarioPojo.getIdUsuario() );
        usuarioEntity.setNombre( usuarioPojo.getNombre() );

        return usuarioEntity;
    }
}
