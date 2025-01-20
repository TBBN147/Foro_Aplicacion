package com.foro_martin.ForoAplicacion.domain.respuesta.validaciones.actualizar;

import com.foro_martin.ForoAplicacion.domain.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}