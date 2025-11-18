package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Asistencia;
import com.example.escuelamusica.model.Clase;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteController {
    private final HorarioController horarioController;
    private final AsistenciaController asistenciaController;
    private final CursoController cursoController;
    private final EstudianteController estudianteController;

    public ReporteController(HorarioController horarioController,
                             AsistenciaController asistenciaController,
                             CursoController cursoController,
                             EstudianteController estudianteController) {
        this.horarioController = horarioController;
        this.asistenciaController = asistenciaController;
        this.cursoController = cursoController;
        this.estudianteController = estudianteController;
    }

    // porcentaje de clases por salón en el período
    public Map<String, Double> ocupacionAulasPorPeriodo(LocalDate desde, LocalDate hasta) {
        Map<String, Integer> totalesPorSalon = new HashMap<>();
        List<Clase> clases = horarioController.listarClases();
        int total = 0;
        for (int i = 0; i < clases.size(); i++) {
            Clase c = clases.get(i);
            if (c.getFecha() == null) continue;
            if ((c.getFecha().isEqual(desde) || c.getFecha().isAfter(desde)) &&
                    (c.getFecha().isEqual(hasta) || c.getFecha().isBefore(hasta))) {
                String salonId = (c.getSalon() == null) ? "SIN-SALON" : c.getSalon().getId();
                Integer v = totalesPorSalon.get(salonId);
                if (v == null) v = 0;
                totalesPorSalon.put(salonId, v + 1);
                total++;
            }
        }
        Map<String, Double> result = new HashMap<>();
        for (String k : totalesPorSalon.keySet()) {
            int v = totalesPorSalon.get(k);
            result.put(k, (v * 100.0) / Math.max(1, total));
        }
        return result;
    }

    // calcula % promedio de asistencia entre clases de cada instrumento
    public Map<String, Double> asistenciaPorInstrumento() {
        Map<String, List<Double>> porcentajesPorInstrumento = new HashMap<>();
        List<Clase> clases = horarioController.listarClases();
        for (int i = 0; i < clases.size(); i++) {
            Clase c = clases.get(i);
            Curso curso = c.getCurso();
            String key = (curso == null || curso.getInstrumento() == null) ? "SIN-INSTRUMENTO" : curso.getInstrumento().name();
            double pct = c.calcularPorcentajeAsistencia();
            List<Double> list = porcentajesPorInstrumento.get(key);
            if (list == null) {
                list = new ArrayList<>();
                porcentajesPorInstrumento.put(key, list);
            }
            list.add(pct);
        }
        Map<String, Double> promedio = new HashMap<>();
        for (String k : porcentajesPorInstrumento.keySet()) {
            List<Double> vals = porcentajesPorInstrumento.get(k);
            double sum = 0.0;
            for (int j = 0; j < vals.size(); j++) sum += vals.get(j);
            promedio.put(k, sum / Math.max(1, vals.size()));
        }
        return promedio;
    }

    // porcentaje de estudiantes inscritos que ya aprobaron
    public Map<String, Double> progresoPorCurso(String cursoId) {
        Map<String, Double> out = new HashMap<>();
        Curso curso = cursoController.buscarCursoPorId(cursoId);
        if (curso == null) {
            out.put("error", 0.0);
            return out;
        }
        List<Estudiante> inscritos = curso.getEstudiantesInscritos();
        if (inscritos == null || inscritos.size() == 0) {
            out.put(cursoId, 0.0);
            return out;
        }
        int aprobados = 0;
        for (int i = 0; i < inscritos.size(); i++) {
            Estudiante e = inscritos.get(i);
            if (estudianteController.haAprobadoCurso(e.getIdEstudiante(), curso)) aprobados++;
        }
        out.put(cursoId, (aprobados * 100.0) / inscritos.size());
        return out;
    }

    // Lista de asistencias global
    public List<Asistencia> todasAsistencias() {
        return asistenciaController.listarTodasAsistencias();
    }

}
