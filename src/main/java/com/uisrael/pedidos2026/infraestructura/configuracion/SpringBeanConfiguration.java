package com.uisrael.pedidos2026.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Casos de uso (Interfaces de entrada)
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICarritoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidoUseCase;
import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IUsuarioUseCase;

// Implementaciones
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.CarritoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.ComprobantesPagoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EntregasUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.EstadosGeneralesUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.HistorialPedidoUseCaseImpl;
import com.uisrael.pedidos2026.aplicacion.casosuso.impl.UsuarioUseCaseImpl;

// Repositorios del Dominio
import com.uisrael.pedidos2026.dominio.repositorios.ICarritoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IComprobantesPagoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEntregasRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IEstadosGeneralesRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IHistorialPedidoRepositorio;
import com.uisrael.pedidos2026.dominio.repositorios.IUsuarioRepositorio;

@Configuration
public class SpringBeanConfiguration {

    @Bean
<<<<<<< HEAD
    public IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
=======
    IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new UsuarioUseCaseImpl(usuarioRepositorio);
    }

    @Bean
<<<<<<< HEAD
    public ICarritoUseCase carritoUseCase(ICarritoRepositorio carritoRepositorio) {
=======
    ICarritoUseCase carritoUseCase(ICarritoRepositorio carritoRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new CarritoUseCaseImpl(carritoRepositorio);
    }

    @Bean
<<<<<<< HEAD
    public IHistorialPedidoUseCase historialPedidoUseCase(IHistorialPedidoRepositorio historialPedidoRepositorio) {
=======
    IHistorialPedidoUseCase historialPedidoUseCase(IHistorialPedidoRepositorio historialPedidoRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new HistorialPedidoUseCaseImpl(historialPedidoRepositorio);
    }

    @Bean
<<<<<<< HEAD
    public IEstadosGeneralesUseCase estadosGeneralesUseCase(IEstadosGeneralesRepositorio estadosGeneralesRepositorio) {
=======
    IEstadosGeneralesUseCase estadosGeneralesUseCase(IEstadosGeneralesRepositorio estadosGeneralesRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new EstadosGeneralesUseCaseImpl(estadosGeneralesRepositorio);
    }

    @Bean
<<<<<<< HEAD
    public IEntregasUseCase entregasUseCase(IEntregasRepositorio entregasRepositorio) {
=======
    IEntregasUseCase entregasUseCase(IEntregasRepositorio entregasRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new EntregasUseCaseImpl(entregasRepositorio);
    }

    @Bean
<<<<<<< HEAD
    public IComprobantesPagoUseCase comprobantesPagoUseCase(IComprobantesPagoRepositorio comprobantesPagoRepositorio) {
=======
    IComprobantesPagoUseCase comprobantesPagoUseCase(IComprobantesPagoRepositorio comprobantesPagoRepositorio) {
>>>>>>> 8f1af7345385b1bebdda2f3b0949329c6756315e
        return new ComprobantesPagoUseCaseImpl(comprobantesPagoRepositorio);
    }
    
}