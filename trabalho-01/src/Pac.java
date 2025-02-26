public class Pac implements ServicoEntrega{
    @Override
    public double calcularFrete(double pesoTotal) {
        if (pesoTotal < 1) {
            return 10;
        } else if (pesoTotal < 2) {
            return 15;
        } else if (pesoTotal < 3) {
            return 20;
        } else if (pesoTotal <= 5) {
            return 30;
        }
        return -1;
    }
}
