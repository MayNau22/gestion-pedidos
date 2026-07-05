package com.uisrael.pedidos2026.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IPedidosUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.PedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.PedidosResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IPedidosDtoMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/pedidos")
public class pedidosController {
	
	private final IPedidosUseCase pedidosUseCase;
	private final IPedidosDtoMapper mapper;
	
	public pedidosController(IPedidosUseCase pedidosUseCase, IPedidosDtoMapper mapper) {
		super();
		this.pedidosUseCase = pedidosUseCase;
		this.mapper = mapper;
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidosResponseDto guardar(@Valid @RequestBody PedidosRequestDto pedidosRequestDto) {
		return mapper.toResponseDto(pedidosUseCase.guardar(mapper.toDomain(pedidosRequestDto)));
	}
	

	@GetMapping
	public List<PedidosResponseDto> listarTodo(){
		return pedidosUseCase. listarTodos().stream().map(mapper :: toResponseDto). toList();	
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int idPedidos){
		pedidosUseCase.eliminar(idPedidos);
		return ResponseEntity.noContent().build();
		}
	

}
