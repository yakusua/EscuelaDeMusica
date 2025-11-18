package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Clase;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private final List<Curso> cursos = new ArrayList<>();

    public CursoController() { }

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
            if (cursos.get(i).getIdCurso().equals(id)) return cursos.get(i);
        }
        return null;
    }

    public List<Curso> listarCursos() {
        List<Curso> copia = new ArrayList<>();
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

    public boolean ajustarCapacidad(String id, int nuevaCap) {
        Curso c = buscarCursoPorId(id);
        if (c == null) {
            System.out.println("Aviso: curso no encontrado: " + id);
            return false;
        }
        if (nuevaCap <= 0) {
            System.out.println("Aviso: capacidad inválida.");
            return false;
        }
        c.setCapacidad(nuevaCap);
        guardarCurso(c);
        return true;
    }

    // lista de estudiantes inscritos
    public List<Estudiante> listarInscritos(String cursoId) {
        Curso c = buscarCursoPorId(cursoId);
        List<Estudiante> res = new ArrayList<>();
        if (c == null) return res;
        List<Estudiante> inscritos = c.getEstudiantesInscritos();
        for (int i = 0; i < inscritos.size(); i++) res.add(inscritos.get(i));
        return res;
    }
}

