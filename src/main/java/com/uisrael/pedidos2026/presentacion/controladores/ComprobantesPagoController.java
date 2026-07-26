package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IComprobantesPagoUseCase;
import com.uisrael.pedidos2026.dominio.entidades.ComprobantesPago;
import com.uisrael.pedidos2026.presentacion.dto.request.ComprobantesPagoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ComprobantesPagoResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IComprobantesPagoDtoMapper;

@Controller
public class ComprobantesPagoController {

    private final IComprobantesPagoUseCase useCase;
    private final IComprobantesPagoDtoMapper mapper;

    public ComprobantesPagoController(IComprobantesPagoUseCase useCase, IComprobantesPagoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    // ==================== VISTAS THYMELEAF (HTML) ====================

    @GetMapping("/comprobantespago")
    public String listarWeb(Model model) {
        List<ComprobantesPagoResponseDto> lista = useCase.listarTodos().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        model.addAttribute("listaComprobantes", lista);
        return "comprobantesPago/listarcomprobantespago";
    }

    @GetMapping("/comprobantespago/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("comprobantepago", new ComprobantesPagoRequestDto());
        return "comprobantesPago/crearcomprobantepago";
    }

    @PostMapping("/comprobantespago/guardar")
    public String guardarWeb(@ModelAttribute("comprobantepago") ComprobantesPagoRequestDto dto) {
        useCase.guardar(mapper.toDomain(dto));
        return "redirect:/comprobantespago";
    }

    // ==================== API REST (JSON) ====================

    @PostMapping("/api/comprobantes-pago")
    @ResponseBody
    public ResponseEntity<ComprobantesPagoResponseDto> crear(@RequestBody ComprobantesPagoRequestDto dto) {
        ComprobantesPago nuevo = useCase.guardar(mapper.toDomain(dto));
        return new ResponseEntity<>(mapper.toResponseDto(nuevo), HttpStatus.CREATED);
    }

    @GetMapping("/api/comprobantes-pago/{id}")
    @ResponseBody
    public ResponseEntity<ComprobantesPagoResponseDto> buscarPorId(@PathVariable int id) {
        ComprobantesPago encontrado = useCase.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDto(encontrado));
    }

    @GetMapping("/api/comprobantes-pago")
    @ResponseBody
    public ResponseEntity<List<ComprobantesPagoResponseDto>> listar() {
        List<ComprobantesPagoResponseDto> lista = useCase.listarTodos().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/api/comprobantes-pago/{id}")
    @ResponseBody
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}