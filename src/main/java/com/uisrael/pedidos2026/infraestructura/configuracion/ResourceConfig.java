package com.uisrael.pedidos2026.infraestructura.configuracion;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {

        Path carpeta =
                Paths.get(
                        "C:",
                        "pedidosweb",
                        "imagenes",
                        "pagos"
                )
                .toAbsolutePath()
                .normalize();

        String ubicacionFisica =
                carpeta.toUri().toString();

        System.out.println(
                "Publicando comprobantes desde: "
                + ubicacionFisica
        );

        registry
                .addResourceHandler(
                        "/comprobantes/**"
                )
                .addResourceLocations(
                        ubicacionFisica
                );
    }
}