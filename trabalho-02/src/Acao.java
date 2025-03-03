import java.util.ArrayList;
import java.util.Iterator;

public class Acao implements Subject {
    private String nome;
    private double valor;
    private ArrayList<Observer> investidoresInscritos;
    private ArrayList<Command> registrosPendentes;

    public Acao(String nome, double valor) {
        setNome(nome);
        setValor(valor);
        investidoresInscritos = new ArrayList<Observer>();
        ordens = new ArrayList<Ordem>();
        registrosPendentes = new ArrayList<Command>();
    }

    public ArrayList<Command> getRegistrosPendentes() {
        return registrosPendentes;
    }

    public void setRegistrosPendentes(ArrayList<Command> registrosPendentes) {
        this.registrosPendentes = registrosPendentes;
    }

    private ArrayList<Ordem> ordens;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Observer> getInvestidoresInscritos() {
        return investidoresInscritos;
    }

    public void setInvestidoresInscritos(ArrayList<Observer> investidoresInscritos) {
        this.investidoresInscritos = investidoresInscritos;
    }

    public ArrayList<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(ArrayList<Ordem> ordens) {
        this.ordens = ordens;
    }

    public void preProgramarRegistro(Command operacao) {
        getRegistrosPendentes().add(operacao);
    }

    public void registrarOrdem(Command operacao) {
        operacao.executar(this);

        Ordem ordem = operacao.getOrdem();

        if (verificarMatch(ordem)) {
            atualizarValor(ordem.getValorOperacao());
        }
    }

    private boolean verificarMatch(Ordem novaOrdem) {
        TipoOrdem tipoProcurado = (novaOrdem.getTipo() == TipoOrdem.COMPRA) ? TipoOrdem.VENDA: TipoOrdem.COMPRA;

        for (Ordem ordem : getOrdens()) {
            if (ordem.getTipo() == tipoProcurado && ordem.getValorOperacao() == novaOrdem.getValorOperacao()) {
                // MATCH
                getOrdens().remove(ordem);
                getOrdens().remove(novaOrdem);
                return true;
            }
        }
        return false;
    }

    private void executarRegistrosPendentes() {
        ArrayList<Command> registrosParaRemover = new ArrayList<>();

        for (Command registro : new ArrayList<>(getRegistrosPendentes())) {
            if (((OrdemAgendada) registro.getOrdem()).getValorAlvo() == getValor()) {
                registrarOrdem(registro);
                registrosParaRemover.add(registro);
            }
        }

        getRegistrosPendentes().removeAll(registrosParaRemover);
    }

    private void atualizarValor(double novoValor) {
        setValor(novoValor);
        notificar();
        executarRegistrosPendentes();
    }

    public String toString() {
        String dados = "";

        if (!getOrdens().isEmpty()) {
            dados += "Ordens\n";
            for (Ordem ordem : getOrdens()) {
                dados += ordem.toString() + "\n";
            }
        }

        if (!getRegistrosPendentes().isEmpty()) {
            dados += "Pendentes\n";
            for (Command registro : getRegistrosPendentes()) {
                dados += registro.getOrdem().toString() + "\n";
            }

        }

        return dados;
    }

    @Override
    public void inscrever(Observer observer) {
        getInvestidoresInscritos().add(observer);
    }

    @Override
    public void desinscrever(Observer observer) {
        getInvestidoresInscritos().remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer observer : getInvestidoresInscritos()) {
            observer.atualizar(getNome(), getValor());
        }
    }
}
