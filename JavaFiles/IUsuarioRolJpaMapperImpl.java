package com.uisrael.pedidos2026.infraestructura.persistencia.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.UsuarioRol;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.UsuarioRolesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IUsuarioRolJpaMapperImpl implements IUsuarioRolJpaMapper {

    @Override
    public UsuarioRol toDomain(UsuarioRolesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioRol usuarioRol = new UsuarioRol();

        usuarioRol.setIdUsuarioRol( entity.getIdUsuarioRol() );

        return usuarioRol;
    }

    @Override
    public UsuarioRolesEntity toEntity(UsuarioRol usuarioRolPojo) {
        if ( usuarioRolPojo == null ) {
            return null;
        }

        UsuarioRolesEntity usuarioRolesEntity = new UsuarioRolesEntity();

        usuarioRolesEntity.setIdUsuarioRol( usuarioRolPojo.getIdUsuarioRol() );

        return usuarioRolesEntity;
    }
}
