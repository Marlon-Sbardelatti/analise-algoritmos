package org.example;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
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
        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();
        ArCondicionado ar = new VentoBaumnAdapter(arVentoBaumn);
        controle.ligar(new ControlarAr(ar));

        String esperado = "Ligando seu ar Vento Baumn!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeControleDesligarArVentoBaumn() {
        ControleUniversal controle = new ControleUniversal();
        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();
        ArCondicionado ar = new VentoBaumnAdapter(arVentoBaumn);
        controle.desligar(new ControlarAr(ar));

        String esperado = "Desligando seu ar Vento Baumn!" + System.lineSeparator();

        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeDefinirTemperatura() {
        ControleUniversal controle = new ControleUniversal();
        ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionado ar = new GellaKazaAdapter(arGellaKaza);
        controle.ligar(new ControlarAr(ar));
        ar.definirTemperatura(22);

        String esperado = "Ligando seu ar Gella Kaza!" + System.lineSeparator() + "Temperatura: 22 °C"
                + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testeAumentarTemperaturaSemLigar() {
        ControleUniversal controle = new ControleUniversal();
        ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionado ar = new GellaKazaAdapter(arGellaKaza);
        ar.definirTemperatura(35);
        ar.aumentarTemperatura();
    }

    @Test
    public void testeDiminuirTemperatura() {
        ControleUniversal controle = new ControleUniversal();
        ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionado ar = new GellaKazaAdapter(arGellaKaza);
        controle.ligar(new ControlarAr(ar));
        ar.definirTemperatura(22);
        String esperado = "Temperatura: 22 °C" + System.lineSeparator();
        output.reset();
        ar.diminuirTemperatura();

        esperado = "Temperatura: 21 °C" + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

    @Test
    public void testeAumentarTemperatura() {
        ControleUniversal controle = new ControleUniversal();
        ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionado ar = new GellaKazaAdapter(arGellaKaza);
        controle.ligar(new ControlarAr(ar));
        ar.definirTemperatura(27);
        String esperado = "Temperatura: 27 °C" + System.lineSeparator();
        output.reset();
        ar.aumentarTemperatura();

        esperado = "Temperatura: 28 °C" + System.lineSeparator();
        assertEquals(esperado, output.toString());
    }

}