package org.example;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class GellaKazaCommand implements CommandAr{
    private ArCondicionadoGellaKaza arCondicionado;

    public GellaKazaCommand() {
        this.arCondicionado = new ArCondicionadoGellaKaza();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        int temperaturaAtual = arCondicionado.getTemperatura();
        int deltaGraus = temperatura - temperaturaAtual;

        if (deltaGraus > 0) {
            for (int i = 0; i < deltaGraus; i++) {
                arCondicionado.aumentarTemperatura();
            }
        } else if (deltaGraus < 0) {
            for (int i = deltaGraus; i < 0; i++) {
                arCondicionado.diminuirTemperatura();
            }
        }

        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void ligar() {
        System.out.println("Ligando seu ar Gella Kaza!");
        arCondicionado.ativar();
    }

    @Override
    public void desligar() {
        System.out.println("Desligando seu ar Gella Kaza!");
        arCondicionado.desativar();
    }
}
