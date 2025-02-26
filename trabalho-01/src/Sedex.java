public class Sedex implements ServicoEntrega{
    @Override
    public double calcularFrete(double pesoTotal) {
        if (pesoTotal < 0.5) {
            return 12.5;
        } else if (pesoTotal < 0.75) {
            return 20;
        } else if (pesoTotal < 1.2) {
            return 30;
        } else if (pesoTotal <= 2) {
            return 45;
        }

        double adicional = calcularAdicional(pesoTotal);
        return 46.5 + (1.5 * adicional);
    }

    private double calcularAdicional(double pesoTotal) {
        return (pesoTotal - 2) / 0.1;
    }
}
