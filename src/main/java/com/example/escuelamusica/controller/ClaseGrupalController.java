package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClaseGrupalController {
    private List<ClaseGrupal> clases = new ArrayList<>();

    public void crear(ClaseGrupal cg) {
        clases.add(cg);
    }

    public List<ClaseGrupal> listar() {
        return clases;
    }

    public ClaseGrupal buscarPorId(String id) {
        for (ClaseGrupal cg : clases) {
            if (cg.getId().equals(id)) return cg;
        }
        return null;
    }

    public void actualizar(ClaseGrupal actualizado) {
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getId().equals(actualizado.getId())) {
                clases.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        clases.removeIf(cg -> cg.getId().equals(id));
    }

    public List<ClaseGrupal> listarClases() {
        return clases;
    }

    public boolean hayCupo(ClaseGrupal clase) {
        return clase.getEstudiantesInscritos().size() < clase.getCurso().getCapacidad();
    }

    public boolean agregarEstudiante(ClaseGrupal clase, Estudiante estudiante) {
        if (!hayCupo(clase)) return false;
        if (clase.getEstudiantesInscritos().contains(estudiante)) return false;

        clase.getEstudiantesInscritos().add(estudiante);
        return true;
    }

    public boolean removerEstudiante(ClaseGrupal clase, Estudiante estudiante) {
        return clase.getEstudiantesInscritos().remove(estudiante);
    }

    public List<Estudiante> listarEstudiantes(ClaseGrupal clase) {
        return clase.getEstudiantesInscritos();
    }

    public void asignarProfesor(ClaseGrupal clase, Profesor profesor) {
        clase.setProfesor(profesor);
    }

    public void asignarSalon(ClaseGrupal clase, Salon salon) {
        clase.setSalon(salon);
    }

    public void asignarCurso(ClaseGrupal clase, Curso curso) {
        clase.setCurso(curso);
    }

    public List<ClaseGrupal> obtenerClasesPorCurso(Curso curso) {
        List<ClaseGrupal> resultado = new ArrayList<>();
        for (ClaseGrupal cg : clases) {
            if (cg.getCurso() != null &&
                    cg.getCurso().getIdCurso().equals(curso.getIdCurso())) {
                resultado.add(cg);
            }
        }
        return resultado;
    }

    public List<ClaseGrupal> obtenerClasesPorProfesor(Profesor profesor) {
        List<ClaseGrupal> resultado = new ArrayList<>();
        for (ClaseGrupal cg : clases) {
            if (cg.getProfesor() != null &&
                    cg.getProfesor().getIdProfesor().equals(profesor.getIdProfesor())) {
                resultado.add(cg);
            }
        }
        return resultado;
    }

    public List<ClaseGrupal> obtenerClasesPorFecha(LocalDate fecha) {
        List<ClaseGrupal> resultado = new ArrayList<>();
        for (ClaseGrupal cg : clases) {
            if (cg.getFecha().equals(fecha)) {
                resultado.add(cg);
            }
        }
        return resultado;
    }

    public boolean hayConflictoHorario(ClaseGrupal nuevaClase) {
        for (ClaseGrupal cg : clases) {

            boolean mismaFecha = cg.getFecha().equals(nuevaClase.getFecha());
            boolean mismaHora = cg.getHora().equals(nuevaClase.getHora());

            if (mismaFecha && mismaHora) {

                if (cg.getProfesor() != null &&
                        nuevaClase.getProfesor() != null &&
                        cg.getProfesor().getIdProfesor().equals(nuevaClase.getProfesor().getIdProfesor())) {
                    return true;
                }

                if (cg.getSalon() != null &&
                        nuevaClase.getSalon() != null &&
                        cg.getSalon().getId().equals(nuevaClase.getSalon().getId())) {
                    return true;
                }
            }
        }
        return false;
    }}
