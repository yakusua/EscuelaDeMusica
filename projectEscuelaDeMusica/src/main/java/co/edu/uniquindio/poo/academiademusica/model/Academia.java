package co.edu.uniquindio.poo.academiademusica.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Academia {
    private String nombre;
    private String nit;
    private String ubicacion;

    private LinkedList<Estudiante> listEstudiantes;
    private LinkedList<Profesor> listProfesores;
    private LinkedList<Curso> listCursos;
    private LinkedList<Salon> listSalones;
    private LinkedList<AdministradorAcademico> listAdministradores;
    private LinkedList<ReporteProgreso> listReportes;

    public Academia(String nombre, String nit, String ubicacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;

        this.listEstudiantes = new LinkedList<>();
        this.listProfesores = new LinkedList<>();
        this.listCursos = new LinkedList<>();
        this.listSalones = new LinkedList<>();
        this.listAdministradores = new LinkedList<>();
        this.listReportes = new LinkedList<>();
    }

    // ---------------- ESTUDIANTES ----------------

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        return listEstudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String idEstudiante) {
        for (Estudiante e : listEstudiantes) {
            if (e.getIdEstudiante().equals(idEstudiante)) {
                return e;
            }
        }
        return null;
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(listEstudiantes);
    }

    public boolean actualizarEstudiante(String id, Estudiante actualizado) {
        for (int i = 0; i < listEstudiantes.size(); i++) {
            if (listEstudiantes.get(i).getIdEstudiante().equals(id)) {
                listEstudiantes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(String idEstudiante) {
        return listEstudiantes.removeIf(e -> e.getIdEstudiante().equals(idEstudiante));
    }

    // ---------------- PROFESORES ----------------

    public boolean agregarProfesor(Profesor profesor) {
        if (profesor == null) return false;
        return listProfesores.add(profesor);
    }

    public Profesor buscarProfesor(String idProfesor) {
        for (Profesor p : listProfesores) {
            if (p.getIdProfesor().equals(idProfesor)) {
                return p;
            }
        }
        return null;
    }

    public List<Profesor> listarProfesores() {
        return new ArrayList<>(listProfesores);
    }

    public boolean actualizarProfesor(String id, Profesor actualizado) {
        for (int i = 0; i < listProfesores.size(); i++) {
            if (listProfesores.get(i).getIdProfesor().equals(id)) {
                listProfesores.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProfesor(String idProfesor) {
        return listProfesores.removeIf(p -> p.getIdProfesor().equals(idProfesor));
    }

    // ---------------- CURSOS ----------------

    public boolean agregarCurso(Curso curso) {
        if (curso == null) return false;
        return listCursos.add(curso);
    }

    public Curso buscarCurso(String idCurso) {
        for (Curso c : listCursos) {
            if (c.getIdCurso().equals(idCurso)) {
                return c;
            }
        }
        return null;
    }

    public List<Curso> listarCursos() {
        return new ArrayList<>(listCursos);
    }

    public boolean actualizarCurso(String idCurso, Curso actualizado) {
        for (int i = 0; i < listCursos.size(); i++) {
            if (listCursos.get(i).getIdCurso().equals(idCurso)) {
                listCursos.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCurso(String idCurso) {
        return listCursos.removeIf(c -> c.getIdCurso().equals(idCurso));
    }

    // ---------------- SALONES ----------------

    public boolean agregarSalon(Salon salon) {
        if (salon == null) return false;
        return listSalones.add(salon);
    }

    public Salon buscarSalon(String nombre) {
        for (Salon s : listSalones) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }

    public List<Salon> listarSalones() {
        return new ArrayList<>(listSalones);
    }

    public boolean actualizarSalon(String nombre, Salon actualizado) {
        for (int i = 0; i < listSalones.size(); i++) {
            if (listSalones.get(i).getNombre().equalsIgnoreCase(nombre)) {
                listSalones.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarSalon(String nombre) {
        return listSalones.removeIf(s -> s.getNombre().equalsIgnoreCase(nombre));
    }

    // ---------------- ADMINISTRADORES ----------------

    public boolean agregarAdministrador(AdministradorAcademico administrador) {
        if (administrador == null) return false;
        return listAdministradores.add(administrador);
    }

    public AdministradorAcademico buscarAdministrador(String id) {
        for (AdministradorAcademico a : listAdministradores) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public List<AdministradorAcademico> listarAdministradores() {
        return new ArrayList<>(listAdministradores);
    }

    public boolean actualizarAdministrador(String id, AdministradorAcademico actualizado) {
        for (int i = 0; i < listAdministradores.size(); i++) {
            if (listAdministradores.get(i).getId().equals(id)) {
                listAdministradores.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarAdministrador(String id) {
        return listAdministradores.removeIf(a -> a.getId().equals(id));
    }

    // ---------------- REPORTES ----------------

    public boolean agregarReporte(ReporteProgreso reporte) {
        if (reporte == null) return false;
        return listReportes.add(reporte);
    }

    public ReporteProgreso buscarReporte(String id) {
        for (ReporteProgreso r : listReportes) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public List<ReporteProgreso> listarReportes() {
        return new ArrayList<>(listReportes);
    }

    public boolean actualizarReporte(String id, ReporteProgreso actualizado) {
        for (int i = 0; i < listReportes.size(); i++) {
            if (listReportes.get(i).getId().equals(id)) {
                listReportes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarReporte(String id) {
        return listReportes.removeIf(r -> r.getId().equals(id));
    }
}
