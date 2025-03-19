package org.example;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class ShoyuMiAdapter implements Lampada {
    private LampadaShoyuMi lampada;

    public ShoyuMiAdapter(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        System.out.println("Ligando a lâmpada ShoyuMi!");
        lampada.ligar();
    }

    @Override
    public void desligar() {
        System.out.println("Desligando a lâmpada ShoyuMi!");
       lampada.desligar();
    }
}
