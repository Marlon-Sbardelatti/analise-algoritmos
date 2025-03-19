package org.example;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ControleArTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testeControleArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        VentoBaumnCommand ar = new VentoBaumnCommand();
        controle.setCommand(ar);
        ar.ligar();

        String esperado = "Ligando seu ar Vento Baumn!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleDesligarArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        VentoBaumnCommand ar = new VentoBaumnCommand();
        controle.setCommand(ar);
        ar.desligar();

        String esperado = "Desligando seu ar Vento Baumn!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDefinirTemperatura() {
        ControleUniversal controle = new ControleUniversal();
        GellaKazaCommand ar = new GellaKazaCommand();
        controle.setCommand(ar);
        ar.ligar();
        ar.definirTemperatura(22);

        String esperado = "Ligando seu ar Gella Kaza!" + System.lineSeparator() + "Temperatura: 22"
                + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testeAumentarTemperaturaSemLigar() {
        ControleUniversal controle = new ControleUniversal();
        VentoBaumnCommand ar = new VentoBaumnCommand();
        controle.setCommand(ar);
        ar.definirTemperatura(22);
    }

    @Test
    public void testeDiminuirTemperatura() {
        GellaKazaCommand ar = new GellaKazaCommand();
        ar.ligar();
        ar.definirTemperatura(22);
        String esperado = "Temperatura: 22" + System.lineSeparator();
        output.reset();
        ar.diminuirTemperatura();

        esperado = "Temperatura: 21" + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeAumentarTemperatura() {
        VentoBaumnCommand ar = new VentoBaumnCommand();
        ar.ligar();
        ar.definirTemperatura(35);
        String esperado = "Temperatura: 35" + System.lineSeparator();
        output.reset();
        ar.diminuirTemperatura();

        esperado = "Temperatura: 34" + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

}