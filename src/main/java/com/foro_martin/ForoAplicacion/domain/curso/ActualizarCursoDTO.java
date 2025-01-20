package com.foro_martin.ForoAplicacion.domain.curso;

public record ActualizarCursoDTO(
        String name,
        Categoria categoria,
        Boolean activo) {
}
