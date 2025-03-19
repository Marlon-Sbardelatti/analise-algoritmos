package org.example;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControleLampadaTest {
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testeLigarLampadaShoyuMi() {
        ControleUniversal controle = new ControleUniversal();

        LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();
        Lampada lampada = new ShoyuMiAdapter(lampadaShoyuMi);

        controle.ligar(new ControlarLampada(lampada));

        String esperado = "Ligando a lâmpada ShoyuMi!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDesligarLampadaShoyuMi() {
        ControleUniversal controle = new ControleUniversal();

        LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();
        Lampada lampada = new ShoyuMiAdapter(lampadaShoyuMi);

        controle.desligar(new ControlarLampada(lampada));

        String esperado = "Desligando a lâmpada ShoyuMi!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();

        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();
        ArCondicionado ar = new VentoBaumnAdapter(arVentoBaumn);

        controle.ligar(new ControlarAr(ar));

        String esperado = "Ligando seu ar Vento Baumn!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeLigarLampadaPhellipes() {
        ControleUniversal controle = new ControleUniversal();

        LampadaPhellipes lampadaPhellipes = new LampadaPhellipes();
        Lampada lampada = new PhellipesAdapter(lampadaPhellipes);

        controle.ligar(new ControlarLampada(lampada));

        String esperado = "Ligando a lâmpada Phellipes!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDesligarLampadaPhellipes() {
        ControleUniversal controle = new ControleUniversal();

        LampadaPhellipes lampadaPhellipes = new LampadaPhellipes();
        Lampada lampada = new PhellipesAdapter(lampadaPhellipes);

        controle.desligar(new ControlarLampada(lampada));

        String esperado = "Desligando a lâmpada Phellipes!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }
}