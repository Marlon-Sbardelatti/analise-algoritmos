package org.example;

public class ControlePersiana {
    private CommandPersiana command;

    public CommandPersiana getCommand() {
        return command;
    }

    public void setCommand(CommandPersiana command) {
        this.command = command;
    }

    public void abrir() {
        getCommand().abrir();
    }

    public void fechar() {
        getCommand().fechar();
    }
}
