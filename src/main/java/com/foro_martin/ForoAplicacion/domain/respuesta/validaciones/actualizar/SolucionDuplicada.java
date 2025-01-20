package com.foro_martin.ForoAplicacion.domain.respuesta.validaciones.actualizar;

import com.foro_martin.ForoAplicacion.domain.respuesta.ActualizarRespuestaDTO;
import com.foro_martin.ForoAplicacion.domain.respuesta.Respuesta;
import com.foro_martin.ForoAplicacion.domain.respuesta.RespuestaRepository;
import com.foro_martin.ForoAplicacion.domain.topico.Estado;
import com.foro_martin.ForoAplicacion.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}
