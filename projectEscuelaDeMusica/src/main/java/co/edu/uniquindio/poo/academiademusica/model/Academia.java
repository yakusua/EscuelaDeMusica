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

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        return listEstudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return null;
        for (Estudiante e : listEstudiantes) {
            if (e.equals(estudiante)) {
                return e;
            }
        }
        return null;
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(listEstudiantes);
    }

    public boolean actualizarEstudiante(Estudiante original, Estudiante actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listEstudiantes.size(); i++) {
            if (listEstudiantes.get(i).equals(original)) {
                listEstudiantes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        return listEstudiantes.remove(estudiante);
    }

    public boolean agregarProfesor(Profesor profesor) {
        if (profesor == null) return false;
        return listProfesores.add(profesor);
    }

    public Profesor buscarProfesor(Profesor profesor) {
        if (profesor == null) return null;
        for (Profesor p : listProfesores) {
            if (p.equals(profesor)) {
                return p;
            }
        }
        return null;
    }

    public List<Profesor> listarProfesores() {
        return new ArrayList<>(listProfesores);
    }

    public boolean actualizarProfesor(Profesor original, Profesor actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listProfesores.size(); i++) {
            if (listProfesores.get(i).equals(original)) {
                listProfesores.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProfesor(Profesor profesor) {
        if (profesor == null) return false;
        return listProfesores.remove(profesor);
    }

    public boolean agregarCurso(Curso curso) {
        if (curso == null) return false;
        return listCursos.add(curso);
    }

    public Curso buscarCurso(Curso curso) {
        if (curso == null) return null;
        for (Curso c : listCursos) {
            if (c.equals(curso)) {
                return c;
            }
        }
        return null;
    }

    public List<Curso> listarCursos() {
        return new ArrayList<>(listCursos);
    }

    public boolean actualizarCurso(Curso original, Curso actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listCursos.size(); i++) {
            if (listCursos.get(i).equals(original)) {
                listCursos.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCurso(Curso curso) {
        if (curso == null) return false;
        return listCursos.remove(curso);
    }

    public boolean agregarSalon(Salon salon) {
        if (salon == null) return false;
        return listSalones.add(salon);
    }

    public Salon buscarSalon(Salon salon) {
        if (salon == null) return null;
        for (Salon s : listSalones) {
            if (s.equals(salon)) {
                return s;
            }
        }
        return null;
    }

    public List<Salon> listarSalones() {
        return new ArrayList<>(listSalones);
    }
    public boolean actualizarSalon(Salon original, Salon actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listSalones.size(); i++) {
            if (listSalones.get(i).equals(original)) {
                listSalones.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarSalon(Salon salon) {
        if (salon == null) return false;
        return listSalones.remove(salon);
    }

    public boolean agregarAdministrador(AdministradorAcademico administrador) {
        if (administrador == null) return false;
        return listAdministradores.add(administrador);
    }

    public AdministradorAcademico buscarAdministrador(AdministradorAcademico administrador) {
        if (administrador == null) return null;
        for (AdministradorAcademico a : listAdministradores) {
            if (a.equals(administrador)) {
                return a;
            }
        }
        return null;
    }

    public List<AdministradorAcademico> listarAdministradores() {
        return new ArrayList<>(listAdministradores);
    }

    public boolean actualizarAdministrador(AdministradorAcademico original, AdministradorAcademico actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listAdministradores.size(); i++) {
            if (listAdministradores.get(i).equals(original)) {
                listAdministradores.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarAdministrador(AdministradorAcademico administrador) {
        if (administrador == null) return false;
        return listAdministradores.remove(administrador);
    }

    public boolean agregarReporte(ReporteProgreso reporte) {
        if (reporte == null) return false;
        return listReportes.add(reporte);
    }

    public ReporteProgreso buscarReporte(ReporteProgreso reporte) {
        if (reporte == null) return null;
        for (ReporteProgreso r : listReportes) {
            if (r.equals(reporte)) {
                return r;
            }
        }
        return null;
    }

    public List<ReporteProgreso> listarReportes() {
        return new ArrayList<>(listReportes);
    }
    public boolean actualizarReporte(ReporteProgreso original, ReporteProgreso actualizado) {
        if (original == null || actualizado == null) return false;
        for (int i = 0; i < listReportes.size(); i++) {
            if (listReportes.get(i).equals(original)) {
                listReportes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarReporte(ReporteProgreso reporte) {
        if (reporte == null) return false;
        return listReportes.remove(reporte);
    }
}