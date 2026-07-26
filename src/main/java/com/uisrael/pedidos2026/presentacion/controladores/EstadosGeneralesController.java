package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEstadosGeneralesUseCase;
import com.uisrael.pedidos2026.dominio.entidades.EstadosGenerales;
import com.uisrael.pedidos2026.presentacion.dto.request.EstadosGeneralesRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EstadosGeneralesResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IEstadosGeneralesDtoMapper;

@Controller
public class EstadosGeneralesController {

    private final IEstadosGeneralesUseCase useCase;
    private final IEstadosGeneralesDtoMapper mapper;

    public EstadosGeneralesController(IEstadosGeneralesUseCase useCase, IEstadosGeneralesDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    // ==================== VISTAS THYMELEAF (HTML) ====================

    @GetMapping({"/estadosgenerales", "/estadosGenerales"})
    public String listarWeb(Model model) {
        List<EstadosGeneralesResponseDto> lista = useCase.listarTodos().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        model.addAttribute("listaEstados", lista);
        return "estadosGenerales/listarestadosgenerales";
    }

    @GetMapping({"/estadosgenerales/nuevo", "/estadosGenerales/nuevo"})
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("estadoGeneral", new EstadosGeneralesRequestDto());
        return "estadosGenerales/crearestadogeneral";
    }

    @PostMapping({"/estadosgenerales/guardar", "/estadosGenerales/guardar"})
    public String guardarWeb(@ModelAttribute("estadoGeneral") EstadosGeneralesRequestDto dto) {
        useCase.guardar(mapper.toDomain(dto));
        return "redirect:/estadosgenerales";
    }

    // ==================== API REST (JSON) ====================

    @GetMapping("/api/estadosgenerales")
    @ResponseBody
    public ResponseEntity<List<EstadosGeneralesResponseDto>> listar() {
        List<EstadosGeneralesResponseDto> lista = useCase.listarTodos().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/api/estadosgenerales/{id}")
    @ResponseBody
    public ResponseEntity<EstadosGeneralesResponseDto> buscarPorId(@PathVariable int id) {
        EstadosGenerales encontrado = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(encontrado));
    }

    @PostMapping("/api/estadosgenerales")
    @ResponseBody
    public ResponseEntity<EstadosGeneralesResponseDto> crear(@RequestBody EstadosGeneralesRequestDto dto) {
        EstadosGenerales nuevo = useCase.guardar(mapper.toDomain(dto));
        return new ResponseEntity<>(mapper.toResponseDto(nuevo), HttpStatus.CREATED);
    }

    @PutMapping("/api/estadosgenerales/{id}")
    @ResponseBody
    public ResponseEntity<EstadosGeneralesResponseDto> actualizar(
            @PathVariable int id, 
            @RequestBody EstadosGeneralesRequestDto dto) {
        
        EstadosGenerales entidad = mapper.toDomain(dto);
        entidad.setIdEstado(id); // Se asigna el ID recibido por URL a la entidad
        EstadosGenerales actualizado = useCase.guardar(entidad);
        
        return ResponseEntity.ok(mapper.toResponseDto(actualizado));
    }

    @DeleteMapping("/api/estadosgenerales/{id}")
    @ResponseBody
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}