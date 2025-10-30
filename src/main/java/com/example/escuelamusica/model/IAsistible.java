package com.example.escuelamusica.model;

import java.util.List;

public interface IAsistible {

    void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado);

    List<Asistencia> consultarAsistencias();

    List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante);

    double calcularPorcentajeAsistencia();
}