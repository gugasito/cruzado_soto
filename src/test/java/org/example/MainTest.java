package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testObtenerUltimoEspacio() {
        int resultadoEsperado= 2;
        String[][] registro = {{"benja","casado","23"},{"guga","soltero","21"},{null,null,null}};
        assertEquals(Main.obtenerUltimoEspacio(registro),resultadoEsperado);
    }

    @Test
    void testHayCupo() {
        boolean resultadoEsperado= true;
        String[][] registro = {{"benja","casado","23"},{"guga","soltero","21"},{null,null,null}};
        assertEquals(Main.hayCupo(registro),resultadoEsperado);
    }

    @Test
    void testOpa() {
        int resultadoEsperado= 1;
        String[][] registro = {{"benja","casado","23"},{"guga","soltero","21"},{null,null,null}};
        assertEquals(Main.opa(registro),resultadoEsperado);
    }
}