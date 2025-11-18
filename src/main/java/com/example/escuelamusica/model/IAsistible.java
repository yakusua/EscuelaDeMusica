package com.example.escuelamusica.model;

import java.util.List;

public interface IAsistible {
    boolean registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado);
    List<Asistencia> consultarAsistencias();
    List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante);
    double calcularPorcentajeAsistencia();
}
