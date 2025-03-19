package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ControleArTest {

    public ByteArrayOutputStream output;

    @Test
    public void testeControleArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        VentoBaumnCommand ar = new VentoBaumnCommand();
        controle.setCommand(ar);

        String esperado = "Ligando seu ar Vento Baumn!" + System.lineSeparator();

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ar.ligar();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleDesligarArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        VentoBaumnCommand ar = new VentoBaumnCommand();
        controle.setCommand(ar);

        String esperado = "Desligando seu ar Vento Baumn!" + System.lineSeparator();

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ar.desligar();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleArGellaKaza(){
        ControleUniversal controle = new ControleUniversal();
        GellaKazaCommand ar = new GellaKazaCommand();
    }


}