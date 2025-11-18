package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorAcademicoTest {

    private AdministradorAcademico admin;

    @BeforeEach
    void setUp() {
        admin = new AdministradorAcademico("Carlos", "carlos@a.com", "ADM01");
    }

    @Test
    void getIdAdministrador() {
        assertEquals("ADM01", admin.getIdAdministrador());
    }

    @Test
    void setIdAdministrador() {
        admin.setIdAdministrador("ADM02");
        assertEquals("ADM02", admin.getIdAdministrador());
    }


    @Test
    void getId() {
        // Como el método getId() retorna null, comprobamos que sea null
        assertNull(admin.getId());
    }
}
