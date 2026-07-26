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

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IDetallePedidosUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.DetallePedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.DetallePedidosResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IDetallePedidosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detallepedidos")
public class DetallePedidosController {
	

	private final IDetallePedidosUseCase detallePedidosUseCase;
	private final IDetallePedidosDtoMapper mapper;
	
	public DetallePedidosController(IDetallePedidosUseCase detallePedidosUseCase, IDetallePedidosDtoMapper mapper) {
		super();
		this.detallePedidosUseCase = detallePedidosUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetallePedidosResponseDto guardar(@Valid @RequestBody DetallePedidosRequestDto detallepedidosRequestDto) {
		return mapper.toResponseDto(detallePedidosUseCase.guardar(mapper.toDomain(detallepedidosRequestDto)));
	}
	
	@GetMapping
	public List<DetallePedidosResponseDto> listarTodo(){
		return detallePedidosUseCase. listarTodos().stream().map(mapper :: toResponseDto). toList();	
	}
	
	@DeleteMapping("/{idDetallePedidos}")
	public ResponseEntity<Void> eliminar(@PathVariable int idDetallePedidos){
		detallePedidosUseCase.eliminar(idDetallePedidos);
		return ResponseEntity.noContent().build();
		}
	
	

}
