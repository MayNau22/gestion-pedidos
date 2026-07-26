package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.CategoriaResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.ICategoriaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final ICategoriaUseCase categoriaUseCase;
    private final ICategoriaDtoMapper mapper;

    public CategoriaController(
            ICategoriaUseCase categoriaUseCase,
            ICategoriaDtoMapper mapper) {

        this.categoriaUseCase = categoriaUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDto guardar(
            @Valid @RequestBody
            CategoriaRequestDto categoriaRequestDto) {

        return mapper.toResponseDto(
                categoriaUseCase.guardar(
                        mapper.toDomain(categoriaRequestDto)
                )
        );
    }

    @GetMapping
    public List<CategoriaResponseDto> listarTodos() {

        return categoriaUseCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/id/{idCategoria}")
    public CategoriaResponseDto buscarPorId(
            @PathVariable int idCategoria) {

        return mapper.toResponseDto(
                categoriaUseCase.buscarId(idCategoria)
        );
    }

    @PutMapping("/id/{idCategoria}")
    public CategoriaResponseDto actualizar(
            @PathVariable int idCategoria,
            @Valid @RequestBody
            CategoriaRequestDto categoriaRequestDto) {

        categoriaRequestDto.setIdCategoria(idCategoria);

        return mapper.toResponseDto(
                categoriaUseCase.actualizar(
                        mapper.toDomain(categoriaRequestDto)
                )
        );
    }


    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> eliminar(
            @PathVariable int idCategoria) {

        categoriaUseCase.eliminar(idCategoria);

        return ResponseEntity.noContent().build();
    }

  
    @PutMapping("/activar/{idCategoria}")
    public ResponseEntity<Void> activar(
            @PathVariable int idCategoria) {

        categoriaUseCase.activar(idCategoria);

        return ResponseEntity.ok().build();
    }
}