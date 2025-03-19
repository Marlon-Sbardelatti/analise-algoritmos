package org.example;

import br.furb.analise.algoritmos.PersianaNatLight;

public class NatLightCommand implements CommandPersiana{
    private PersianaNatLight persiana;

    public NatLightCommand() {
        this.persiana = new PersianaNatLight();
    }

    @Override
    public void abrir() {
        try {
            System.out.println("Abrindo a persiana NatLight!");
            persiana.subirPalheta();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fechar() {
        System.out.println("Fechando a persiana NatLight!");
        persiana.descerPalheta();
    }
}
