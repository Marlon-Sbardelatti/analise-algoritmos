package org.example;

public class ControlarPersiana implements Command {
    private Persiana persiana;

    public ControlarPersiana(Persiana persiana) {
        this.persiana = persiana;
    }

    @Override
    public void ligar() {
        this.persiana.abrir();
    }

    @Override
    public void desligar() {
        this.persiana.fechar();
    }
}
