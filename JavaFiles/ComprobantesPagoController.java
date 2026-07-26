package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.presentacion.dto.request.ComprobantesPagoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ComprobantesPagoResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IComprobantesPagoDtoMapper;

@RestController
@RequestMapping("/api/v1/comprobantes-pago")
public class ComprobantesPagoController {

    private final IComprobantesPagoUseCase useCase;
    private final IComprobantesPagoDtoMapper mapper;

    public ComprobantesPagoController(IComprobantesPagoUseCase useCase, IComprobantesPagoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ComprobantesPagoResponseDto> crear(@RequestBody ComprobantesPagoRequestDto dto) {
        ComprobantesPago nuevo = useCase.guardar(mapper.toDomain(dto));
        return new ResponseEntity<>(mapper.toResponseDto(nuevo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComprobantesPagoResponseDto> buscarPorId(@PathVariable int id) {
        ComprobantesPago encontrado = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(encontrado));
    }

    @GetMapping
    public ResponseEntity<List<ComprobantesPagoResponseDto>> listar() {
        List<ComprobantesPagoResponseDto> lista = useCase.listarTodos().stream()
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