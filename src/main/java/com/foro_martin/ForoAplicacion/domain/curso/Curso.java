package com.foro_martin.ForoAplicacion.domain.curso;

import jakarta.persistence.*;
import java.util.Objects;

@Table(name = "cursos")
@Entity(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean activo;

    // Constructor vacío
    public Curso() {
    }

    // Constructor completo
    public Curso(Long id, String name, Categoria categoria, Boolean activo) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.activo = activo;
    }

    // Constructor desde CrearCursoDTO
    public Curso(CrearCursoDTO crearCursoDTO) {
        this.name = crearCursoDTO.name();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true; // Automáticamente el curso estará activo.
    }

    // Métodos de actualización
    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {
        if (actualizarCursoDTO.name() != null) {
            this.name = actualizarCursoDTO.name();
        }
        if (actualizarCursoDTO.categoria() != null) {
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null) {
            this.activo = actualizarCursoDTO.activo();
        }
    }

    public void eliminarCurso() {
        this.activo = false;
    }

    // Métodos getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Boolean getActivo() {
        return activo;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
