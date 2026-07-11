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

import com.uisrael.pedidos2026.aplicacion.casosuso.entrada.IHistorialPedidosUseCase;
import com.uisrael.pedidos2026.presentacion.dto.request.HistorialPedidosRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.HistorialPedidosResponseDto;
import com.uisrael.pedidos2026.presentacion.mapeadores.IHistorialPedidosDtoMapper;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/historialpedidos")
public class HistorialPedidosController {

	

	private final IHistorialPedidosUseCase historialPedidosUseCase;
	private final IHistorialPedidosDtoMapper mapper;
	
	public HistorialPedidosController(IHistorialPedidosUseCase historialPedidosUseCase,
			IHistorialPedidosDtoMapper mapper) {
		super();
		this.historialPedidosUseCase = historialPedidosUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistorialPedidosResponseDto guardar(@Valid @RequestBody HistorialPedidosRequestDto historialPedidosRequestDto) {
		return mapper.toResponseDto(historialPedidosUseCase.guardar(mapper.toDomain(historialPedidosRequestDto)));
	}
	
	@GetMapping
	public List<HistorialPedidosResponseDto> listarTodo(){
		return historialPedidosUseCase. listarTodos().stream().map(mapper :: toResponseDto). toList();	
	}
	
	
	@DeleteMapping("/{idHistorialPedidos}")
	public ResponseEntity<Void> eliminar(@PathVariable int idHistorialPedidos){
		historialPedidosUseCase.eliminar(idHistorialPedidos);
		return ResponseEntity.noContent().build();
		}
	

	
}
