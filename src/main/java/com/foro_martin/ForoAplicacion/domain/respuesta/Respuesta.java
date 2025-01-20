package com.foro_martin.ForoAplicacion.domain.respuesta;

import com.foro_martin.ForoAplicacion.domain.topico.Topico;
import com.foro_martin.ForoAplicacion.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    private Boolean solucion;

    private Boolean borrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    // Constructor vacío
    public Respuesta() {
    }

    // Constructor completo
    public Respuesta(Long id, String mensaje, LocalDateTime fechaCreacion, LocalDateTime ultimaActualizacion,
                     Boolean solucion, Boolean borrado, Usuario usuario, Topico topico) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.ultimaActualizacion = ultimaActualizacion;
        this.solucion = solucion;
        this.borrado = borrado;
        this.usuario = usuario;
        this.topico = topico;
    }

    // Constructor con DTO
    public Respuesta(CrearRespuestaDTO crearRespuestaDTO, Usuario usuario, Topico topico) {
        this.mensaje = crearRespuestaDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaActualizacion = LocalDateTime.now();
        this.solucion = false;
        this.borrado = false;
        this.usuario = usuario;
        this.topico = topico;
    }

    // Métodos de actualización
    public void actualizarRespuesta(ActualizarRespuestaDTO actualizarRespuestaDTO) {
        if (actualizarRespuestaDTO.mensaje() != null) {
            this.mensaje = actualizarRespuestaDTO.mensaje();
        }
        if (actualizarRespuestaDTO.solucion() != null) {
            this.solucion = actualizarRespuestaDTO.solucion();
        }
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public void eliminarRespuesta() {
        this.borrado = true;
    }

    // Métodos getter
    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Respuesta respuesta = (Respuesta) o;
        return Objects.equals(id, respuesta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
