package org.example;

import br.furb.analise.algoritmos.PersianaSolarius;

public class SolariusAdapter implements Persiana{
    private PersianaSolarius persiana;

    public SolariusAdapter(PersianaSolarius persiana) {
        this.persiana = persiana;
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
