package org.example;

public class ControleUniversal {
    private Object command;

    public Object getCommand() {
        return command;
    }

    public void setCommand(Object command) {
        this.command = command;
    }

    public void ligar() {
        if (getCommand() instanceof CommandAr) {
            ((CommandAr) getCommand()).ligar();
        } else if (getCommand() instanceof CommandLampada) {
            ((CommandLampada) getCommand()).ligar();
        } else if (getCommand() instanceof CommandPersiana) {
            ((CommandPersiana) getCommand()).abrir();
        } else {
            throw new RuntimeException("Dispositivo não disponível");
        }
    }

    public void desligar() {
        if (getCommand() instanceof CommandAr) {
            ((CommandAr) getCommand()).desligar();
        } else if (getCommand() instanceof CommandLampada) {
            ((CommandLampada) getCommand()).desligar();
        } else if (getCommand() instanceof CommandPersiana) {
            ((CommandPersiana) getCommand()).fechar();
        } else {
            throw new RuntimeException("Dispositivo não disponível");
        }
    }
}
