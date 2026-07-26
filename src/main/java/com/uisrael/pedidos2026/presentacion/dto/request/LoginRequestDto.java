package com.uisrael.pedidos2026.presentacion.dto.request;
import lombok.Data;

@Data
public class LoginRequestDto {

	private String correo;
    private String contrasena;

    public LoginRequestDto() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}