package org.example;

public class ControleLampada {
    private CommandLampada command;

    public CommandLampada getCommand() {
        return command;
    }

    public void setCommand(CommandLampada command) {
        this.command = command;
    }

    public void ligar() {
        getCommand().ligar();
    }

    public void desligar() {
        getCommand().desligar();
    }
}
