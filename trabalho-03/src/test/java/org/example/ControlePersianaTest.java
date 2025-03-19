package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControlePersianaTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testeAbrirPersianaNatLight() {
        ControleUniversal controle = new ControleUniversal();
        NatLightCommand persiana = new NatLightCommand();
        controle.setCommand(persiana);
        persiana.abrir();

        String esperado = "Abrindo a persiana NatLight!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeFecharPersianaNatLight() {
        ControleUniversal controle = new ControleUniversal();
        NatLightCommand persiana = new NatLightCommand();
        controle.setCommand(persiana);
        persiana.fechar();

        String esperado = "Fechando a persiana NatLight!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeAbrirPersianaSolarius() {
        ControleUniversal controle = new ControleUniversal();
        SolariusCommand persiana = new SolariusCommand();
        controle.setCommand(persiana);
        persiana.abrir();

        String esperado = "Abrindo a persiana Solarius!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeFecharPersianaSolarius() {
        ControleUniversal controle = new ControleUniversal();
        SolariusCommand persiana = new SolariusCommand();
        controle.setCommand(persiana);
        persiana.fechar();

        String esperado = "Fechando a persiana Solarius!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

}
