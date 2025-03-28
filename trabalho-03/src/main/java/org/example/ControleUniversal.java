package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleUniversal {
    private List<Command> dispositivos = new ArrayList<Command>();

    public void ligar(Command command) {
        command.ligar();

        if (command instanceof ControlarAr) {
            ((ControlarAr) command).definirTemperatura(25);
        }
    }

    public void desligar(Command command) {
        command.desligar();
    }

    public void registrarDispositivo(Command command) {
        dispositivos.add(command);
    }

    public void ativarModoSono() {
        for (Command dispositivo : dispositivos) {
            dispositivo.desligar();
        }
    }

    public void ativarModoTrabalho() {
        for (Command dispositivo : dispositivos) {
            dispositivo.ligar();

            if (dispositivo instanceof ControlarAr) {
                ((ControlarAr) dispositivo).definirTemperatura(25);
            }
        }
    }
}
