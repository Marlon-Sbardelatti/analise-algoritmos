package org.example;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class VentoBaumnCommand implements CommandAr{
    private ArCondicionadoVentoBaumn arCondicionado;

    public VentoBaumnCommand() {
        this.arCondicionado = new ArCondicionadoVentoBaumn();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionado.definirTemperatura(temperatura);
        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void aumentarTemperatura() {
       int temperaturaAtual = arCondicionado.getTemperatura();
       arCondicionado.definirTemperatura(temperaturaAtual + 1);
        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void diminuirTemperatura() {
        int temperaturaAtual = arCondicionado.getTemperatura();
        arCondicionado.definirTemperatura(temperaturaAtual - 1);
        System.out.println("Temperatura: " + arCondicionado.getTemperatura());
    }

    @Override
    public void ligar() {
        System.out.println("Ligando seu ar Vento Baumn!");
       arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        System.out.println("Desligando seu ar Vento Baumn!");
       arCondicionado.desligar();
    }
}
