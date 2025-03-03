public class OrdemAgendada extends Ordem{
    private double valorAlvo;

    public OrdemAgendada(String nomeInvestidor, double valorOperacao, double valorAlvo) {
        super(nomeInvestidor, valorOperacao);
        setValorAlvo(valorAlvo);
    }

    public double getValorAlvo() {
        return valorAlvo;
    }

    public void setValorAlvo(double valorAlvo) {
        this.valorAlvo = valorAlvo;
    }
}
