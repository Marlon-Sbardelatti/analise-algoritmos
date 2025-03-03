public class RegistrarOrdemCompra extends Command {
    public RegistrarOrdemCompra(Ordem ordem) {
        super(ordem);
        ordem.setTipo(TipoOrdem.COMPRA);
    }

    @Override
    public void executar(Acao acao) {
       acao.getOrdens().add(getOrdem());
    }
}
