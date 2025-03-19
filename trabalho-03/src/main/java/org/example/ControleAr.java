package org.example;

public class ControleAr {
    private CommandAr command;

    public CommandAr getCommand() {
        return command;
    }

    public void setCommand(CommandAr command) {
        this.command = command;
    }

    public void ligar() {
        getCommand().ligar();
    }

    public void desligar() {
        getCommand().desligar();
    }

    public void aumentarTemperatura() {
        getCommand().aumentarTemperatura();
    }

    public void diminuirTemperatura() {
        getCommand().diminuirTemperatura();
    }

    public void definirTemperatura(int temperatura) {
        getCommand().definirTemperatura(temperatura);
    }

}
