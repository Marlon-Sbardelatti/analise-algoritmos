package org.example;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class ShoyuMiCommand implements CommandLampada{
    private LampadaShoyuMi lampada;

    public ShoyuMiCommand() {
        this.lampada = new LampadaShoyuMi();
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
