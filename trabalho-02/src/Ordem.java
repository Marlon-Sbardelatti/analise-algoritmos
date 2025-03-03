import java.text.DecimalFormat;

public abstract class Ordem {
    private String nomeInvestidor;
    private double valorOperacao;
    private TipoOrdem tipo;

    public Ordem(String nomeInvestidor, double valorOperacao) {
        setNomeInvestidor(nomeInvestidor);
        setValorOperacao(valorOperacao);
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void setNomeInvestidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public TipoOrdem getTipo() {
        return tipo;
    }

    public void setTipo(TipoOrdem tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Investidor: " + getNomeInvestidor() + "\nValor: R$ " + df.format(getValorOperacao()) + "\nTipo: " + getTipo();
    }
}
