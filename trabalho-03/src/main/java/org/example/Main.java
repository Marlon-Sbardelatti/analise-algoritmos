package org.example;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaSolarius;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
         // Criando dispositivos reais
        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();
        LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();
        PersianaSolarius persianaSolarius = new PersianaSolarius();

        // Criando os adapters para padronizar o controle
        ArCondicionado ar = new VentoBaumnAdapter(arVentoBaumn);
        Lampada lampada = new ShoyuMiAdapter(lampadaShoyuMi);
        Persiana persiana = new SolariusAdapter(persianaSolarius);

        // Criando controle universal
        ControleUniversal controle = new ControleUniversal();

        // Registrando dispositivos no controle
        controle.registrarDispositivo(new ControlarAr(ar));
        controle.registrarDispositivo(new ControlarLampada(lampada));
        controle.registrarDispositivo(new ControlarPersiana(persiana));

        // Testando modos
        controle.ativarModoTrabalho();  // Liga tudo
        controle.ativarModoSono();   // Desliga tudo
    }
}

