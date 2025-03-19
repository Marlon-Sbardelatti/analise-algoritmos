package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControleLampadaTest {

    public ByteArrayOutputStream output;

    @Test
    public void testeControleArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        ShoyuMiCommand lampada = new ShoyuMiCommand();
        controle.setCommand(lampada);

        String esperado = "Ligando a lâmpada ShoyuMi!" + System.lineSeparator();

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        lampada.ligar();

        assertEquals(esperado, output.toString());
    }
}