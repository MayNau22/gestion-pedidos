package com.uisrael.pedidos2026.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "recuperacion_password",
    indexes = {
        @Index(
            name = "idx_recuperacion_token",
            columnList = "token"
        ),
        @Index(
            name = "idx_recuperacion_usuario",
            columnList = "id_usuario"
        )
    }
)
public class RecuperacionPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recuperacion")
    private Integer idRecuperacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_usuario",
        nullable = false
    )
    private UsuarioEntity usuario;

    @Column(
        name = "token",
        nullable = false,
        unique = true,
        length = 255
    )
    private String token;

    @Column(
        name = "fecha_creacion",
        nullable = false
    )
    private Date fechaCreacion;

    @Column(
        name = "fecha_expiracion",
        nullable = false
    )
    private Date fechaExpiracion;

    @Column(
        name = "utilizado",
        nullable = false
    )
    private boolean utilizado;

    public RecuperacionPasswordEntity() {
    }

    public Integer getIdRecuperacion() {
        return idRecuperacion;
    }

    public void setIdRecuperacion(
            Integer idRecuperacion) {

        this.idRecuperacion = idRecuperacion;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(
            UsuarioEntity usuario) {

        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(
            String token) {

        this.token = token;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(
            Date fechaCreacion) {

        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(
            Date fechaExpiracion) {

        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void setUtilizado(
            boolean utilizado) {

        this.utilizado = utilizado;
    }
}