package co.edu.uniquindio.poo.academiademusica.model;
import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;

import java.util.List;

public interface IAsistible {

    void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado);

    List<Asistencia> consultarAsistencias();

    List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante);

    double calcularPorcentajeAsistencia();
}