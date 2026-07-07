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

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.ICarritoUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.CarritoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.CarritoResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.ICarritoDtoMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/carrito")
public class CarritoContoller {
	
	private final ICarritoUseCase carritoUseCase;
	private final ICarritoDtoMapper mapper;
	
	public CarritoContoller(ICarritoUseCase carritoUseCase, ICarritoDtoMapper mapper) {
		super();
		this.carritoUseCase = carritoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarritoResponseDto guardar(@Valid @RequestBody CarritoRequestDto carritoRequestDto) {
		return mapper.toResponseDto(carritoUseCase.guardar(mapper.toDomain(carritoRequestDto)));
	}
	
	@GetMapping
	public List<CarritoResponseDto> listarTodo(){
		return carritoUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	public ResponseEntity<Void> eliminar(@PathVariable int idCarrito){
		carritoUseCase.eliminar(idCarrito);
		return ResponseEntity.noContent().build();	
		}
	
}
