package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;
import com.example.escuelamusica.model.Matricula;

import java.util.ArrayList;
import java.util.List;

public class MatriculaController {
    private final List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private final List<Curso> cursos = new ArrayList<Curso>();

    public MatriculaController() { }

    // CRUD

    public boolean guardarEstudiante(Estudiante e) {
        if (e == null) {
            System.out.println("Aviso: estudiante nulo. No se guarda.");
            return false;
        }
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(e.getIdEstudiante())) {
                estudiantes.set(i, e);
                System.out.println("Estudiante actualizado: " + e.getIdEstudiante());
                return true;
            }
        }
        estudiantes.add(e);
        System.out.println("Estudiante agregado: " + e.getIdEstudiante());
        return true;
    }

    public Estudiante buscarEstudiantePorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            if (e != null && id.equals(e.getIdEstudiante())) return e;
        }
        return null;
    }

    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> copia = new ArrayList<Estudiante>();
        for (int i = 0; i < estudiantes.size(); i++) copia.add(estudiantes.get(i));
        return copia;
    }

    public boolean eliminarEstudiante(String id) {
        if (id == null) return false;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(id)) {
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado: " + id);
                return true;
            }
        }
        System.out.println("Aviso: estudiante no encontrado: " + id);
        return false;
    }

    // CRUD

    public boolean guardarCurso(Curso c) {
        if (c == null) {
            System.out.println("Aviso: curso nulo. No se guarda.");
            return false;
        }
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso().equals(c.getIdCurso())) {
                cursos.set(i, c);
                System.out.println("Curso actualizado: " + c.getIdCurso());
                return true;
            }
        }
        cursos.add(c);
        System.out.println("Curso agregado: " + c.getIdCurso());
        return true;
    }

    public Curso buscarCursoPorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < cursos.size(); i++) {
            Curso c = cursos.get(i);
            if (c != null && id.equals(c.getIdCurso())) return c;
        }
        return null;
    }

    public List<Curso> listarCursos() {
        List<Curso> copia = new ArrayList<Curso>();
        for (int i = 0; i < cursos.size(); i++) copia.add(cursos.get(i));
        return copia;
    }

    public boolean eliminarCurso(String id) {
        if (id == null) return false;
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso().equals(id)) {
                cursos.remove(i);
                System.out.println("Curso eliminado: " + id);
                return true;
            }
        }
        System.out.println("Aviso: curso no encontrado: " + id);
        return false;
    }

    // Operaciones de matrícula

    public boolean matricular(String estudianteId, String cursoId) {
        if (estudianteId == null || cursoId == null) {
            System.out.println("Aviso: id nulo recibido.");
            return false;
        }
        Estudiante estudiante = buscarEstudiantePorId(estudianteId);
        if (estudiante == null) {
            System.out.println("Aviso: estudiante no encontrado: " + estudianteId);
            return false;
        }
        Curso curso = buscarCursoPorId(cursoId);
        if (curso == null) {
            System.out.println("Aviso: curso no encontrado: " + cursoId);
            return false;
        }
        if (!curso.hayCupoLocal()) {
            System.out.println("Aviso: curso sin cupo: " + cursoId);
            return false;
        }
        boolean okCurso = curso.inscribirLocal(estudiante);
        boolean okEst = estudiante.inscribirCursoLocal(curso);
        if (okCurso && okEst) {
            // actualizar listas internas
            guardarCurso(curso);
            guardarEstudiante(estudiante);
            System.out.println("Matrícula realizada: estudiante=" + estudianteId + " curso=" + cursoId);
            return true;
        } else {
            System.out.println("Aviso: no se pudo matricular (ya inscrito o error local).");
            return false;
        }
    }

    public boolean desmatricular(String estudianteId, String cursoId) {
        if (estudianteId == null || cursoId == null) {
            System.out.println("Aviso: id nulo recibido.");
            return false;
        }
        Estudiante estudiante = buscarEstudiantePorId(estudianteId);
        Curso curso = buscarCursoPorId(cursoId);
        if (estudiante == null || curso == null) {
            System.out.println("Aviso: estudiante o curso no encontrado.");
            return false;
        }
        boolean okCurso = curso.desinscribirLocal(estudiante);
        // quitar del estudiante
        List<Curso> nuevos = new ArrayList<Curso>();
        for (int i = 0; i < estudiante.getListCursosInscritos().size(); i++) {
            Curso c = estudiante.getListCursosInscritos().get(i);
            if (!c.equals(curso)) nuevos.add(c);
        }
        // no existe setter público para sobrescribir, pero guardamos el estudiante
        guardarCurso(curso);
        guardarEstudiante(estudiante);
        return okCurso;
    }
}
