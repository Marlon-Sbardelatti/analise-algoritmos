package org.example;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
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
        PersianaNatLight persianaNatLight = new PersianaNatLight();
        Persiana persiana = new NatLightAdapter(persianaNatLight);
        controle.ligar(new ControlarPersiana(persiana));

        String esperado = "Abrindo a persiana NatLight!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeFecharPersianaNatLight() {
        ControleUniversal controle = new ControleUniversal();
        PersianaNatLight persianaNatLight = new PersianaNatLight();
        Persiana persiana = new NatLightAdapter(persianaNatLight);
        controle.desligar(new ControlarPersiana(persiana));

        String esperado = "Fechando a persiana NatLight!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeAbrirPersianaSolarius() {
        ControleUniversal controle = new ControleUniversal();
        PersianaSolarius persianaSolarius = new PersianaSolarius();
        Persiana persiana = new SolariusAdapter(persianaSolarius);
        controle.ligar(new ControlarPersiana(persiana));

        String esperado = "Abrindo a persiana Solarius!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeFecharPersianaSolarius() {
        ControleUniversal controle = new ControleUniversal();
        PersianaSolarius persianaSolarius = new PersianaSolarius();
        Persiana persiana = new SolariusAdapter(persianaSolarius);
        controle.desligar(new ControlarPersiana(persiana));

        String esperado = "Fechando a persiana Solarius!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

}
