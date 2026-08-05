package com.uisrael.pedidos2026.presentacion.excepciones;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.uisrael.pedidos2026.dominio.excepciones.StockInsuficienteException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StockInsuficienteException.class)
	public ResponseEntity<Map<String, Object>> manejarStockInsuficiente(StockInsuficienteException exception) {

		Map<String, Object> respuesta = new LinkedHashMap<>();

		respuesta.put("fecha", LocalDateTime.now());

		respuesta.put("estado", HttpStatus.CONFLICT.value());

		respuesta.put("error", "STOCK_INSUFICIENTE");

		respuesta.put("mensaje", exception.getMessage());

		respuesta.put("stockDisponible", exception.getStockDisponible());

		respuesta.put("cantidadSolicitada", exception.getCantidadSolicitada());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> manejarValidaciones(MethodArgumentNotValidException exception) {

		Map<String, String> errores = new LinkedHashMap<>();

		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));

		Map<String, Object> respuesta = new LinkedHashMap<>();

		respuesta.put("fecha", LocalDateTime.now());

		respuesta.put("estado", HttpStatus.BAD_REQUEST.value());

		respuesta.put("error", "DATOS_NO_VALIDOS");

		respuesta.put("mensaje", "Revise los datos enviados");

		respuesta.put("detalles", errores);

		return ResponseEntity.badRequest().body(respuesta);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> manejarErrorNegocio(RuntimeException exception) {

		Map<String, Object> respuesta = new LinkedHashMap<>();

		respuesta.put("fecha", LocalDateTime.now());

		respuesta.put("estado", HttpStatus.BAD_REQUEST.value());

		respuesta.put("error", "OPERACION_NO_VALIDA");

		respuesta.put("mensaje", exception.getMessage());

		return ResponseEntity.badRequest().body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> manejarErrorGeneral(Exception exception) {

		Map<String, Object> respuesta = new LinkedHashMap<>();

		respuesta.put("fecha", LocalDateTime.now());

		respuesta.put("estado", HttpStatus.INTERNAL_SERVER_ERROR.value());

		respuesta.put("error", "ERROR_INTERNO");

		respuesta.put("mensaje", "Ocurrió un problema inesperado. " + "Intente nuevamente.");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
}