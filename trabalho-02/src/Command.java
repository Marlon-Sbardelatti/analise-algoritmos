public abstract class Command {
    private Ordem ordem;

    public Command(Ordem ordem) {
        setOrdem(ordem);
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public abstract void executar(Acao acao);
}
