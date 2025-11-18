package co.edu.uniquindio.poo.academiademusica.model;
public record ReporteProgreso(String id,Estudiante estudiante, Curso curso, double nota, String observaciones) {
    public Object getId() {
        return id;
    }

    public int getProgreso() {
        return 0;
    }
}

