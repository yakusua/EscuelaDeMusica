package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComentarioEstudianteTest {

    @Test
    void getNombre() {
        ComentarioEstudiante comentario = new ComentarioEstudiante("Juan", "Excelente clase");
        assertEquals("Juan", comentario.getNombre());
    }

    @Test
    void getComentario() {
        ComentarioEstudiante comentario = new ComentarioEstudiante("Ana", "Muy buena práctica");
        assertEquals("Muy buena práctica", comentario.getComentario());
    }

    @Test
    void setComentario() {
        ComentarioEstudiante comentario = new ComentarioEstudiante("Pedro", "Inicial");
        comentario.setComentario("Actualizado");
        assertEquals("Actualizado", comentario.getComentario());
    }

    @Test
    void estudianteProperty() {
        ComentarioEstudiante comentario = new ComentarioEstudiante("Luis", "Genial");
        // Actualmente retorna null, verificamos que es null
        assertNull(comentario.estudianteProperty());
    }

    @Test
    void comentarioProperty() {
        ComentarioEstudiante comentario = new ComentarioEstudiante("Luis", "Genial");
        // Actualmente retorna null, verificamos que es null
        assertNull(comentario.comentarioProperty());
    }
}
