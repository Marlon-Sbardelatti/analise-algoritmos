public class RegistrarOrdemVenda extends Command{
    public RegistrarOrdemVenda(Ordem ordem) {
        super(ordem);
        ordem.setTipo(TipoOrdem.VENDA);
    }

    @Override
    public void executar(Acao acao) {
        acao.getOrdens().add(getOrdem());
    }
}
