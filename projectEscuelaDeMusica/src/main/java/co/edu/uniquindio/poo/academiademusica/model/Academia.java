package co.edu.uniquindio.poo.academiademusica.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Academia {
    private String nombre;
    private String nit;
    private String ubicacion;

    //de relación
    private List<Estudiante> listEstudiantes;
    private List<Profesor> listProfesores;
    private List<Curso> listCursos;
    private List<Salon> listSalones;

    public Academia(String nombre, String nit, String ubicacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.listEstudiantes = new ArrayList<>();
        this.listProfesores = new ArrayList<>();
        this.listCursos = new ArrayList<>();
        this.listSalones = new ArrayList<>();
    }

    public List<Salon> getListSalones() {
        return listSalones;
    }

    public void setListSalones(List<Salon> listSalones) {
        this.listSalones = listSalones;
    }

    public List<Curso> getListCursos() {
        return listCursos;
    }

    public void setListCursos(List<Curso> listCursos) {
        this.listCursos = listCursos;
    }

    public List<Profesor> getListProfesores() {
        return listProfesores;
    }

    public void setListProfesores(List<Profesor> listProfesores) {
        this.listProfesores = listProfesores;
    }

    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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


    public boolean agregarProfesor(Profesor profesor) {
        if (profesor == null) return false;
        return listProfesores.add(profesor);
    }

    public Profesor buscarProfesor(String idProfesor) {
        for (Profesor p : listProfesores) {
            if (p.getIdprofesor().equals(idProfesor)) {
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
            if (listProfesores.get(i).getIdprofesor().equals(id)) {
                listProfesores.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProfesor(String idProfesor) {
        return listProfesores.removeIf(p -> p.getIdprofesor().equals(idProfesor));
    }


    public boolean agregarCurso(Curso curso) {
        if (curso == null) return false;
        return listCursos.add(curso);
    }

    public Curso buscarCurso(int capacidad) {
        for (Curso c : listCursos) {
            if (c.getCapacidad() == capacidad) {
                return c;
            }
        }
        return null;
    }

    public List<Curso> listarCursos() {
        return new ArrayList<>(listCursos);
    }

    public boolean actualizarCurso(int capacidad, Curso actualizado) {
        for (int i = 0; i < listCursos.size(); i++) {
            if (listCursos.get(i).getCapacidad() == capacidad) {
                listCursos.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCurso(int capacidad) {
        return listCursos.removeIf(c -> c.getCapacidad() == capacidad);
    }


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
}
