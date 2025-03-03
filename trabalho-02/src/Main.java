public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Acao acao = new Acao("Banco do Brasil", 20);


        Investidor marlon = new Investidor("Marlon");
        marlon.agendarOrdemVenda(acao, 30, 24);
        System.out.println(acao.toString());
        marlon.inscreverSeEmAcao(acao);

        Investidor sara = new Investidor("Sara");
        sara.registrarOrdemVenda(acao, 24);
        System.out.println(acao.toString());

        Investidor sofia = new Investidor("Sofia");
        sofia.registrarOrdemCompra(acao, 24);
        System.out.println(acao.toString());

        System.out.println(acao.getValor());

    }
}