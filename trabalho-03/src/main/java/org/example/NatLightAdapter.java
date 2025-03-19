package org.example;

import br.furb.analise.algoritmos.PersianaNatLight;

public class NatLightAdapter implements Persiana{
    private PersianaNatLight persiana;

    public NatLightAdapter(PersianaNatLight persiana) {
        this.persiana = persiana;
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
