package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.presentacion.dto.request.EntregasRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EntregasResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IEntregasDtoMapper;

@RestController
@RequestMapping("/api/v1/entregas")
public class EntregasController {

    private final IEntregasUseCase useCase;
    private final IEntregasDtoMapper mapper;

    public EntregasController(IEntregasUseCase useCase, IEntregasDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<EntregasResponseDto> crear(@RequestBody EntregasRequestDto dto) {
        Entregas nuevo = useCase.guardar(mapper.toDomain(dto));
        return new ResponseEntity<>(mapper.toResponseDto(nuevo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregasResponseDto> buscarPorId(@PathVariable int id) {
        Entregas encontrado = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(encontrado));
    }

    @GetMapping
    public ResponseEntity<List<EntregasResponseDto>> listar() {
        List<EntregasResponseDto> lista = useCase.listarTodos().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}