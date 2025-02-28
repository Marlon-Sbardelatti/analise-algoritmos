public class Produto {
    private String nome;
    private double valor;
    private double peso;

    public Produto(String nome, double valor, double peso) {
        setNome(nome);
        setValor(valor);
        setPeso(peso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor do produto não pode ser negativo.");
        }
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("Peso do produto não pode ser negativo");
        }
        this.peso = peso;
    }
}