package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPrecioProductoUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.PrecioProductoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.PrecioProductoResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IPrecioProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/precios-productos")
public class PrecioProductoController {

	private final IPrecioProductoUseCase precioUseCase;
	private final IPrecioProductoDtoMapper mapper;

	public PrecioProductoController(IPrecioProductoUseCase precioUseCase, IPrecioProductoDtoMapper mapper) {

		this.precioUseCase = precioUseCase;
		this.mapper = mapper;
	}

	@PostMapping("/producto/{idProducto}")
	@ResponseStatus(HttpStatus.CREATED)
	public PrecioProductoResponseDto registrarPrecio(@PathVariable int idProducto,
			@Valid @RequestBody PrecioProductoRequestDto request) {

		return mapper.toResponseDto(precioUseCase.registrarPrecio(idProducto, request.getPrecio()));
	}

	@GetMapping("/producto/{idProducto}/activo")
	public PrecioProductoResponseDto obtenerActivo(@PathVariable int idProducto) {

		return mapper.toResponseDto(precioUseCase.obtenerPrecioActivo(idProducto));
	}

	@GetMapping("/producto/{idProducto}/historial")
	public List<PrecioProductoResponseDto> listarHistorial(@PathVariable int idProducto) {

		return precioUseCase.listarHistorial(idProducto).stream().map(mapper::toResponseDto).toList();
	}
}