package com.foro_martin.ForoAplicacion.domain.respuesta;

public record ActualizarRespuestaDTO(
        String mensaje,
        Boolean solucion,
        Boolean borrado
) {
}