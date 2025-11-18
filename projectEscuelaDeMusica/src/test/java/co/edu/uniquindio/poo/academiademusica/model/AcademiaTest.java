package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademiaTest {

    private Academia academia;
    private Estudiante est1;
    private Profesor prof1;
    private Curso curso1;
    private Salon salon1;
    private AdministradorAcademico admin1;
    private ReporteProgreso rep1;

    @BeforeEach
    void setUp() {
        academia = new Academia("MiAcademia", "12345", "Armenia");
        est1 = new Estudiante("Juan", "a@a.com", "Estu01", 12, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        prof1 = new Profesor("Carlos", "prof@a.com", "Prof01",Instrumento.GUITARRA,"Cuerdas");
        curso1 = new Curso(12, Instrumento.GUITARRA,Nivel.AVANZADO);
        salon1 = new Salon("Salon1", 20, null);
        admin1 = new AdministradorAcademico("Adm1", "adm@a.com", "Admin01");
        rep1 = new ReporteProgreso("R01", est1, curso1, 4,"Libre");
    }

    // ---------------- ESTUDIANTES ----------------
    @Test
    void agregarEstudiante() {
        assertTrue(academia.agregarEstudiante(est1));
    }

    @Test
    void buscarEstudiante() {
        academia.agregarEstudiante(est1);
        assertEquals(est1, academia.buscarEstudiante("Estu01"));
    }

    @Test
    void listarEstudiantes() {
        academia.agregarEstudiante(est1);
        assertEquals(1, academia.listarEstudiantes().size());
    }

    @Test
    void actualizarEstudiante() {
        academia.agregarEstudiante(est1);
        Estudiante actualizado = new Estudiante("Juan", "a@a.com", "Estu01", 13, Nivel.INTERMEDIO, "Guitarra", 50, 20);
        assertTrue(academia.actualizarEstudiante("Estu01", actualizado));
        assertEquals(13, academia.buscarEstudiante("Estu01").getEdad());
    }

    @Test
    void eliminarEstudiante() {
        academia.agregarEstudiante(est1);
        assertTrue(academia.eliminarEstudiante("Estu01"));
        assertNull(academia.buscarEstudiante("Estu01"));
    }

    // ---------------- PROFESORES ----------------
    @Test
    void agregarProfesor() { assertTrue(academia.agregarProfesor(prof1)); }

    @Test
    void buscarProfesor() {
        academia.agregarProfesor(prof1);
        assertEquals(prof1, academia.buscarProfesor("Prof01"));
    }

    @Test
    void listarProfesores() {
        academia.agregarProfesor(prof1);
        assertEquals(1, academia.listarProfesores().size());
    }


    @Test
    void eliminarProfesor() {
        academia.agregarProfesor(prof1);
        assertTrue(academia.eliminarProfesor("Prof01"));
        assertNull(academia.buscarProfesor("Prof01"));
    }

    // ---------------- CURSOS ----------------
    @Test
    void agregarCurso() { assertTrue(academia.agregarCurso(curso1)); }

    @Test
    void buscarCurso() {
        academia.agregarCurso(curso1);
        assertEquals(curso1, academia.buscarCurso("C01"));
    }

    @Test
    void listarCursos() {
        academia.agregarCurso(curso1);
        assertEquals(1, academia.listarCursos().size());
    }


    @Test
    void eliminarCurso() {
        academia.agregarCurso(curso1);
        assertTrue(academia.eliminarCurso("C01"));
        assertNull(academia.buscarCurso("C01"));
    }

    // ---------------- SALONES ----------------
    @Test
    void agregarSalon() { assertTrue(academia.agregarSalon(salon1)); }

    @Test
    void buscarSalon() {
        academia.agregarSalon(salon1);
        assertEquals(salon1, academia.buscarSalon("Salon1"));
    }

    @Test
    void listarSalones() {
        academia.agregarSalon(salon1);
        assertEquals(1, academia.listarSalones().size());
    }

    @Test
    void actualizarSalon() {
        academia.agregarSalon(salon1);
        Salon actualizado = new Salon("Salon1", 25, null);
        assertTrue(academia.actualizarSalon("Salon1", actualizado));
        assertEquals(25, academia.buscarSalon("Salon1").getCapacidad());
    }

    @Test
    void eliminarSalon() {
        academia.agregarSalon(salon1);
        assertTrue(academia.eliminarSalon("Salon1"));
        assertNull(academia.buscarSalon("Salon1"));
    }

    // ---------------- ADMINISTRADORES ----------------
    @Test
    void agregarAdministrador() { assertTrue(academia.agregarAdministrador(admin1)); }

    @Test
    void buscarAdministrador() {
        academia.agregarAdministrador(admin1);
        assertEquals(admin1, academia.buscarAdministrador("Admin01"));
    }

    @Test
    void listarAdministradores() {
        academia.agregarAdministrador(admin1);
        assertEquals(1, academia.listarAdministradores().size());
    }

    @Test
    void actualizarAdministrador() {
        academia.agregarAdministrador(admin1);
        AdministradorAcademico actualizado = new AdministradorAcademico("Adm1", "adm2@a.com", "Admin01");
        assertTrue(academia.actualizarAdministrador("Admin01", actualizado));
        assertEquals("adm2@a.com", academia.buscarAdministrador("Admin01").getEmail());
    }

    @Test
    void eliminarAdministrador() {
        academia.agregarAdministrador(admin1);
        assertTrue(academia.eliminarAdministrador("Admin01"));
        assertNull(academia.buscarAdministrador("Admin01"));
    }

    // ---------------- REPORTES ----------------
    @Test
    void agregarReporte() { assertTrue(academia.agregarReporte(rep1)); }

    @Test
    void buscarReporte() {
        academia.agregarReporte(rep1);
        assertEquals(rep1, academia.buscarReporte("R01"));
    }

    @Test
    void listarReportes() {
        academia.agregarReporte(rep1);
        assertEquals(1, academia.listarReportes().size());
    }

    @Test
    void eliminarReporte() {
        academia.agregarReporte(rep1);
        assertTrue(academia.eliminarReporte("R01"));
        assertNull(academia.buscarReporte("R01"));
    }
}
