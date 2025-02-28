import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private ServicoEntrega servicoDeEntrega;
    private int numero;
    private String nomeCliente;

    public Pedido() {
        produtos = new ArrayList<>();
    }

    public Pedido(List<Produto> produtos, ServicoEntrega servicoDeEntrega, int numero, String nomeCliente) {
        setNomeCliente(nomeCliente);
        setNumero(numero);
        setProdutos(produtos);
        setServicoDeEntrega(servicoDeEntrega);
        produtos = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        this.nomeCliente = nomeCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
       if (numero < 0) {
           throw new IllegalArgumentException("Número não pode ser negativo");
       }

        this.numero = numero;
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