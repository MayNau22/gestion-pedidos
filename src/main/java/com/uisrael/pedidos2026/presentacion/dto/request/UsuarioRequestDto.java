package com.uisrael.pedidos2026.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequestDto {

    private int idUsuario;

    @NotBlank(message = "La cédula es obligatoria")
    @Pattern(
            regexp = "\\d{10}",
            message = "La cédula debe tener 10 dígitos"
    )
    private String cedula;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Ingrese un correo válido")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(
            min = 6,
            message = "La contraseña debe tener al menos 6 caracteres"
    )
    private String contrasena;

    @NotBlank(message = "El celular es obligatorio")
    @Pattern(
            regexp = "\\d{10}",
            message = "El celular debe tener 10 dígitos"
    )
    private String celular;
}