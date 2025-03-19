package org.example;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class PhellipesAdapter implements Lampada{
    private LampadaPhellipes lampada;

    public PhellipesAdapter(LampadaPhellipes lampada) {
        this.lampada = lampada;
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
