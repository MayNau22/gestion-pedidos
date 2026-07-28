package com.uisrael.pedidos2026.presentacion.controladores;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IEntregasUseCase;
import com.uisrael.pedidos2026.dominio.entidades.Entregas;
import com.uisrael.pedidos2026.presentacion.dto.request.CambiarEstadoEntregaRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.EntregasResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IEntregasDtoMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/entregas")
public class EntregasController {

	private final IEntregasUseCase useCase;
	private final IEntregasDtoMapper mapper;

	public EntregasController(IEntregasUseCase useCase, IEntregasDtoMapper mapper) {

		this.useCase = useCase;
		this.mapper = mapper;
	}

	@GetMapping("/activas")
	public List<EntregasResponseDto> listarActivas() {

		return useCase.listarActivas().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idEntrega}")
	public ResponseEntity<EntregasResponseDto> buscarPorId(@PathVariable int idEntrega) {

		EntregasResponseDto entrega = mapper.toResponseDto(useCase.buscarPorId(idEntrega));

		return ResponseEntity.ok(entrega);
	}

	@GetMapping("/pedido/{idPedido}")
	public ResponseEntity<EntregasResponseDto> buscarPorPedido(@PathVariable int idPedido) {

		EntregasResponseDto entrega = mapper.toResponseDto(useCase.buscarPorPedido(idPedido));

		return ResponseEntity.ok(entrega);
	}

	@PutMapping("/{idEntrega}/estado")
	public ResponseEntity<EntregasResponseDto> cambiarEstado(@PathVariable int idEntrega,

			@Valid @RequestBody CambiarEstadoEntregaRequestDto request) {

		Entregas entregaActualizada = useCase.cambiarEstado(idEntrega, request.getIdEstado(), request.getObservacion());

		return ResponseEntity.ok(mapper.toResponseDto(entregaActualizada));
	}

	@PostMapping(value = "/{idEntrega}/finalizar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EntregasResponseDto> finalizarEntrega(@PathVariable int idEntrega,

			@RequestPart("evidencia") MultipartFile evidencia,

			@RequestPart("recibidoPor") String recibidoPor,

			@RequestPart(value = "observacion", required = false) String observacion) {

		Entregas finalizada = useCase.finalizarEntrega(idEntrega, evidencia, recibidoPor, observacion);

		return ResponseEntity.ok(mapper.toResponseDto(finalizada));
	}

	@GetMapping
	public List<EntregasResponseDto> listarTodos() {

		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
}