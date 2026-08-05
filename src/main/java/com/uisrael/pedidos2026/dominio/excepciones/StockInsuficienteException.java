package com.uisrael.pedidos2026.dominio.excepciones;

public class StockInsuficienteException extends RuntimeException {
	
	private final int stockDisponible;
	private final int cantidadSolicitada;

	public StockInsuficienteException(String nombreProducto, int stockDisponible, int cantidadSolicitada) {

		super("El producto \"" + nombreProducto + "\" no dispone de la cantidad solicitada. " + "Stock disponible: "
				+ stockDisponible + ", cantidad solicitada: " + cantidadSolicitada);

		this.stockDisponible = stockDisponible;
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public int getStockDisponible() {
		return stockDisponible;
	}

	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
}
