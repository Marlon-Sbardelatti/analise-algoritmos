public class Investidor {
    private String nome;

    public Investidor(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registrarOrdemVenda(Acao acao, double valor) {
        OrdemComum ordem = new OrdemComum(getNome(), valor);
        acao.registrarOrdem(new RegistrarOrdemVenda(ordem));
    }

   public void registrarOrdemCompra(Acao acao, double valor) {
        OrdemComum ordem = new OrdemComum(getNome(), valor);
        acao.registrarOrdem(new RegistrarOrdemCompra(ordem));
   }

   public void agendarOrdemVenda(Acao acao, double valor, double valorAlvo) {
        OrdemAgendada ordem = new OrdemAgendada(getNome(), valor, valorAlvo);
        acao.preProgramarRegistro(new RegistrarOrdemVenda(ordem));
   }

   public void agendarOrdemCompra(Acao acao, double valor, double valorAlvo) {
        OrdemAgendada ordem = new OrdemAgendada(getNome(), valor, valorAlvo);
        acao.preProgramarRegistro(new RegistrarOrdemCompra(ordem));
   }

}
