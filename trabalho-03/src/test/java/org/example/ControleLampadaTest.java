package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControleLampadaTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testeLigarLampadaShoyuMi() {
        ControleUniversal controle = new ControleUniversal();
        ShoyuMiCommand lampada = new ShoyuMiCommand();
        controle.setCommand(lampada);
        lampada.ligar();

        String esperado = "Ligando a lâmpada ShoyuMi!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDesligarLampadaShoyuMi() {
        ControleUniversal controle = new ControleUniversal();
        ShoyuMiCommand lampada = new ShoyuMiCommand();
        controle.setCommand(lampada);
        lampada.desligar();

        String esperado = "Desligando a lâmpada ShoyuMi!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        ShoyuMiCommand lampada = new ShoyuMiCommand();
        controle.setCommand(lampada);
        lampada.ligar();

        String esperado = "Ligando a lâmpada ShoyuMi!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeLigarLampadaPhellipes() {
        ControleUniversal controle = new ControleUniversal();
        PhellipesCommand lampada = new PhellipesCommand();
        controle.setCommand(lampada);
        lampada.ligar();

        String esperado = "Ligando a lâmpada Phellipes!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDesligarLampadaPhellipes() {
        ControleUniversal controle = new ControleUniversal();
        PhellipesCommand lampada = new PhellipesCommand();
        controle.setCommand(lampada);
        lampada.desligar();

        String esperado = "Desligando a lâmpada Phellipes!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }
}