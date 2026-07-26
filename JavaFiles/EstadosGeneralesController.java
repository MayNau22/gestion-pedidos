package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.presentacion.dto.request.EstadosGeneralesRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EstadosGeneralesResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IEstadosGeneralesDtoMapper;

@RestController
@RequestMapping("/api/v1/estados-generales")
public class EstadosGeneralesController {

    private final IEstadosGeneralesUseCase useCase;
    private final IEstadosGeneralesDtoMapper mapper;

    public EstadosGeneralesController(IEstadosGeneralesUseCase useCase, IEstadosGeneralesDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<EstadosGeneralesResponseDto> crear(@RequestBody EstadosGeneralesRequestDto dto) {
        EstadosGenerales nuevo = useCase.guardar(mapper.toDomain(dto));
        return new ResponseEntity<>(mapper.toResponseDto(nuevo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadosGeneralesResponseDto> buscarPorId(@PathVariable int id) {
        EstadosGenerales encontrado = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(encontrado));
    }

    @GetMapping
    public ResponseEntity<List<EstadosGeneralesResponseDto>> listar() {
        List<EstadosGeneralesResponseDto> lista = useCase.listarTodos().stream()
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