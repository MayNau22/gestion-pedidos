package com.uisrael.pedidos2026.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.pedidos2026.infraestructura.persistencia.jpa.CarritoEntity;

public interface ICarritoJpaRepositorio extends JpaRepository<CarritoEntity, Integer>{

}
