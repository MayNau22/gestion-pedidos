package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetalleCarritoUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.DetalleCarritoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetalleCarritoResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IDetalleCarritoDtoMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/detalleCarrito")
public class DetalleCarritoController {
	
	private final IDetalleCarritoUseCase detalleCarritoUseCase;
	private final IDetalleCarritoDtoMapper mapper;
	
	
	
	public DetalleCarritoController(IDetalleCarritoUseCase detalleCarritoUseCase, IDetalleCarritoDtoMapper mapper) {
		super();
		this.detalleCarritoUseCase = detalleCarritoUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleCarritoResponseDto guardar(@Valid @RequestBody DetalleCarritoRequestDto detalleCarritoRequestDto) {
		return mapper.toResponseDto(detalleCarritoUseCase.guardar(mapper.toDomain(detalleCarritoRequestDto)));
	}
	
	@GetMapping
	public List<DetalleCarritoResponseDto> listarTodo(){
		return detalleCarritoUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	public ResponseEntity<Void> eliminar(@PathVariable int idCarrito){
		detalleCarritoUseCase.eliminar(idCarrito);
		return ResponseEntity.noContent().build();	
		}

}
