package com.foro_martin.ForoAplicacion.domain.curso;

public record DetalleCursoDTO(Long id, String name, Categoria categoria, Boolean activo) {


    public DetalleCursoDTO(Curso curso){
        this(curso.getId(), curso.getName(), curso.getCategoria(), curso.getActivo());
    }
}