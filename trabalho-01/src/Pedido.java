package src;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private ServicoEntrega servicoDeEntrega;

    public Pedido(){
        produtos = new ArrayList<>();
    }

    public Pedido(List<Produto> produtos, ServicoEntrega servicoDeEntrega) {
        setProdutos(produtos);
        setServicoDeEntrega(servicoDeEntrega);
        produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ServicoEntrega getServicoDeEntrega() {
        return servicoDeEntrega;
    }

    public void setServicoDeEntrega(ServicoEntrega servicoDeEntrega) {
        this.servicoDeEntrega = servicoDeEntrega;
    }

    private Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void inserirProduto(Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
        }
    }

    public void removerProduto(String nome) {
        Produto produto = buscarProduto(nome);

        if (produto != null) {
            produtos.remove(produto);
        }
    }
    
    public double calcularPesoTotal() {
        double pesoTotal = 0;

        for (Produto produto : produtos) {
            pesoTotal += produto.getPeso();
        }
        return pesoTotal;
    }
}
