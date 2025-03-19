package org.example;

import br.furb.analise.algoritmos.PersianaSolarius;

public class SolariusCommand implements CommandPersiana{
    private PersianaSolarius persiana;

    public SolariusCommand() {
        this.persiana = new PersianaSolarius();
    }

    @Override
    public void abrir() {
        System.out.println("Abrindo a persiana Solarius!");
        persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        System.out.println("Fechando a persiana Solarius!");
        persiana.descerPersiana();
    }
}
