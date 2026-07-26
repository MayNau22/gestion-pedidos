package com.uisrael.pedidos2026.dominio.repositorios;

import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import java.util.List;
import java.util.Optional;

public interface IEntregasRepositorio {
    Entregas guardar(Entregas entregas);
    Optional<Entregas> buscarPorId(int idEntrega);
    List<Entregas> listarTodos();
    void eliminar(int idEntrega);
}