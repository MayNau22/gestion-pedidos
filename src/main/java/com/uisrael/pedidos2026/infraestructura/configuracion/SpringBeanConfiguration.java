package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CarritoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ComprobantesPagoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EntregasUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EstadosGeneralesUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.HistorialPedidoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.UsuarioUseCaseImpl;
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public UsuarioUseCaseImpl usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
        return new UsuarioUseCaseImpl(usuarioRepositorio);
    }

    @Bean
    public CarritoUseCaseImpl carritoUseCase(ICarritoRepositorio carritoRepositorio) {
        return new CarritoUseCaseImpl(carritoRepositorio);
    }

    @Bean
    public HistorialPedidoUseCaseImpl historialPedidoUseCase(IHistorialPedidoRepositorio historialPedidoRepositorio) {
        return new HistorialPedidoUseCaseImpl(historialPedidoRepositorio);
    }
    @Bean
    public EstadosGeneralesUseCaseImpl estadosGeneralesUseCase(IEstadosGeneralesRepositorio estadosGeneralesRepositorio) {
        return new EstadosGeneralesUseCaseImpl(estadosGeneralesRepositorio);
    }

    @Bean
    public EntregasUseCaseImpl entregasUseCase(IEntregasRepositorio entregasRepositorio) {
        return new EntregasUseCaseImpl(entregasRepositorio);
    }

    @Bean
    public ComprobantesPagoUseCaseImpl comprobantesPagoUseCase(IComprobantesPagoRepositorio comprobantesPagoRepositorio) {
        return new ComprobantesPagoUseCaseImpl(comprobantesPagoRepositorio);
    }
    
}