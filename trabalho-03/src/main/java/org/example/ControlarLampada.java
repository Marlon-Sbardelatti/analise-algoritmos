package org.example;

public class ControlarLampada implements Command {
    private Lampada lampada;

    public ControlarLampada(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        this.lampada.ligar();
    }

    @Override
    public void desligar() {
        this.lampada.desligar();
    }
}
