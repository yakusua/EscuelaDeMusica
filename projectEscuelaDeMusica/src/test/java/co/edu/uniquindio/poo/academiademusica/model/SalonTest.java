package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalonTest {

    @Test
    void getAdministradorAcademico() {
        AdministradorAcademico admin = new AdministradorAcademico("Juan", "j@j.com", "A1");
        Salon salon = new Salon("Sala 1", 20, admin);

        assertEquals(admin, salon.getAdministradorAcademico());
    }

    @Test
    void setAdministradorAcademico() {
        AdministradorAcademico admin1 = new AdministradorAcademico("Juan", "j@j.com", "A1");
        AdministradorAcademico admin2 = new AdministradorAcademico("Ana", "a@a.com", "A2");

        Salon salon = new Salon("Sala 1", 20, admin1);
        salon.setAdministradorAcademico(admin2);

        assertEquals(admin2, salon.getAdministradorAcademico());
    }

    @Test
    void getClase() {
        Salon salon = new Salon("Sala 1", 20, null);
        Clase clase = null;

        assertNull(salon.getClase());
    }

    @Test
    void setClase() {
        Salon salon = new Salon("Sala 1", 20, null);

        Clase clase = new ClaseGrupal(
                "C1", 1, null, 10,
                null, null, salon, "Guitarra"
        );

        salon.setClase(clase);

        assertEquals(clase, salon.getClase());
    }

    @Test
    void getCapacidad() {
        Salon salon = new Salon("Sala 1", 25, null);
        assertEquals(25, salon.getCapacidad());
    }

    @Test
    void setCapacidad() {
        Salon salon = new Salon("Sala 1", 25, null);
        salon.setCapacidad(40);

        assertEquals(40, salon.getCapacidad());
    }

    @Test
    void getNombre() {
        Salon salon = new Salon("Sala 1", 25, null);
        assertEquals("Sala 1", salon.getNombre());
    }

    @Test
    void setNombre() {
        Salon salon = new Salon("Sala 1", 25, null);
        salon.setNombre("Sala B");

        assertEquals("Sala B", salon.getNombre());
    }

    @Test
    void getAula() {
        Salon salon = new Salon("Sala 1", 25, null);
        salon.setAula("A101");

        assertEquals("A101", salon.getAula());
    }

    @Test
    void setAula() {
        Salon salon = new Salon("Sala 1", 25, null);
        salon.setAula("B203");

        assertEquals("B203", salon.getAula());
    }
}
