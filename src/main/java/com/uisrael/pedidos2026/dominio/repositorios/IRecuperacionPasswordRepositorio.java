package com.uisrael.pedidos2026.dominio.repositorios;

import java.util.Optional;

import com.uisrael.pedidos2026.dominio.entidades.RecuperacionPassword;

public interface IRecuperacionPasswordRepositorio {
	RecuperacionPassword guardar(RecuperacionPassword recuperacion);

	Optional<RecuperacionPassword> buscarPorToken(String token);

}
