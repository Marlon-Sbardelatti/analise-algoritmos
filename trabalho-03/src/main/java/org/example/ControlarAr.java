package org.example;

public class ControlarAr implements Command {
    private ArCondicionado arCondicionado;

    public ControlarAr(ArCondicionado arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        this.arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        this.arCondicionado.desligar();
    }

    public void aumentarTemperatura() {
        this.arCondicionado.aumentarTemperatura();
    }

    public void diminuirTemperatura() {
        this.arCondicionado.diminuirTemperatura();
    }

    public void definirTemperatura(int temperatura) {
        this.arCondicionado.definirTemperatura(temperatura);
    }

}
