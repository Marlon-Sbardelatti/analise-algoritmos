package org.example;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class PhellipesCommand implements CommandLampada{
    private LampadaPhellipes lampada;

    public PhellipesCommand() {
        this.lampada = new LampadaPhellipes();
    }

    @Override
    public void ligar() {
        System.out.println("Ligando a lâmpada Phellipes!");
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        System.out.println("Desligando a lâmpada Phellipes!");
        lampada.setIntensidade(0);
    }
}
