package com.uisrael.pedidos2026.presentacion.controladores;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregasController {

    @Autowired
    private IEntregasUseCase entregasUseCase;

    @GetMapping
    public ResponseEntity<List<Entregas>> listarTodos() {
        List<Entregas> lista = entregasUseCase.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregas> buscarPorId(@PathVariable int id) {
        Entregas entrega = entregasUseCase.buscarPorId(id);
        if (entrega != null) {
            return ResponseEntity.ok(entrega);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Entregas> crear(@RequestBody Entregas entrega) {
        Entregas creado = entregasUseCase.guardar(entrega);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
}