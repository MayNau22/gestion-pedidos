package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.dominio.entidades.Producto;
import com.uisrael.pedidos2026.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.ProductoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IProductoDtoMapperImpl implements IProductoDtoMapper {

    @Override
    public Producto toDomain(ProductoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( productoRequestDtoToCategoria( dto ) );
        producto.setIdProducto( dto.getIdProducto() );
        producto.setNombre( dto.getNombre() );
        producto.setDescripcion( dto.getDescripcion() );
        producto.setPrecio( dto.getPrecio() );
        producto.setStock( dto.getStock() );
        producto.setImagenUrl( dto.getImagenUrl() );
        producto.setDisponible( dto.isDisponible() );
        producto.setFechaCreacion( dto.getFechaCreacion() );

        return producto;
    }

    @Override
    public ProductoResponseDto toResponseDto(Producto productoPojo) {
        if ( productoPojo == null ) {
            return null;
        }

        ProductoResponseDto productoResponseDto = new ProductoResponseDto();

        productoResponseDto.setIdCategoria( productoPojoCategoriaIdCategoria( productoPojo ) );
        productoResponseDto.setIdProducto( productoPojo.getIdProducto() );
        productoResponseDto.setNombre( productoPojo.getNombre() );
        productoResponseDto.setDescripcion( productoPojo.getDescripcion() );
        productoResponseDto.setPrecio( productoPojo.getPrecio() );
        productoResponseDto.setStock( productoPojo.getStock() );
        productoResponseDto.setImagenUrl( productoPojo.getImagenUrl() );
        productoResponseDto.setDisponible( productoPojo.isDisponible() );
        productoResponseDto.setFechaCreacion( productoPojo.getFechaCreacion() );

        return productoResponseDto;
    }

    protected Categoria productoRequestDtoToCategoria(ProductoRequestDto productoRequestDto) {
        if ( productoRequestDto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( productoRequestDto.getCategoria() );

        return categoria;
    }

    private int productoPojoCategoriaIdCategoria(Producto producto) {
        Categoria categoria = producto.getCategoria();
        if ( categoria == null ) {
            return 0;
        }
        return categoria.getIdCategoria();
    }
}
