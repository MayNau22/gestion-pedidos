package com.uisrael.pedidos2026.presentacion.mapeadores;

import com.uisrael.pedidos2026.dominio.entidades.Categoria;
import com.uisrael.pedidos2026.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.pedidos2026.presentacion.dto.response.CategoriaResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T21:32:17-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class ICategoriaDtoMapperImpl implements ICategoriaDtoMapper {

    @Override
    public Categoria toDomain(CategoriaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( dto.getIdCategoria() );
        categoria.setNombre( dto.getNombre() );
        categoria.setDescripcion( dto.getDescripcion() );
        categoria.setEstado( dto.isEstado() );

        return categoria;
    }

    @Override
    public CategoriaResponseDto toResponseDto(Categoria categoriaPojo) {
        if ( categoriaPojo == null ) {
            return null;
        }

        CategoriaResponseDto categoriaResponseDto = new CategoriaResponseDto();

        categoriaResponseDto.setIdCategoria( categoriaPojo.getIdCategoria() );
        categoriaResponseDto.setNombre( categoriaPojo.getNombre() );
        categoriaResponseDto.setDescripcion( categoriaPojo.getDescripcion() );
        categoriaResponseDto.setEstado( categoriaPojo.isEstado() );

        return categoriaResponseDto;
    }
}
