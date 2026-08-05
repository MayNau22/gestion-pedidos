package com.uisrael.pedidos2026.infraestructura.correo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.uisrael.pedidos2026.aplicacion.servicios.ICorreoService;

public class CorreoServiceImpl implements ICorreoService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String correoRemitente;

    public CorreoServiceImpl(
            JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    @Override
    public void enviarCorreoRecuperacion(
            String destinatario,
            String nombreUsuario,
            String enlaceRecuperacion) {

        SimpleMailMessage mensaje =
                new SimpleMailMessage();

        mensaje.setFrom(correoRemitente);
        mensaje.setTo(destinatario);
        mensaje.setSubject(
                "Recuperación de contraseña - NovaPaper"
        );

        mensaje.setText(
                "Hola "
                + nombreUsuario
                + ",\n\n"
                + "Hemos recibido una solicitud para restablecer "
                + "la contraseña de tu cuenta.\n\n"
                + "Ingresa al siguiente enlace:\n\n"
                + enlaceRecuperacion
                + "\n\n"
                + "Este enlace estará disponible durante 30 minutos.\n\n"
                + "Si no realizaste esta solicitud, puedes ignorar "
                + "este mensaje.\n\n"
                + "Saludos,\n"
                + "Equipo NovaPaper"
        );

        mailSender.send(mensaje);
    }
}