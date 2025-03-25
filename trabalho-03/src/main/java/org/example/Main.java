package org.example;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaSolarius;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();
        LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();
        PersianaSolarius persianaSolarius = new PersianaSolarius();

        ArCondicionado ar = new VentoBaumnAdapter(arVentoBaumn);
        Lampada lampada = new ShoyuMiAdapter(lampadaShoyuMi);
        Persiana persiana = new SolariusAdapter(persianaSolarius);

        ControleUniversal controle = new ControleUniversal();

        controle.registrarDispositivo(new ControlarAr(ar));
        controle.registrarDispositivo(new ControlarLampada(lampada));
        controle.registrarDispositivo(new ControlarPersiana(persiana));

        controle.ativarModoTrabalho();  // Liga tudo
        controle.ativarModoSono();   // Desliga tudo
    }
}

