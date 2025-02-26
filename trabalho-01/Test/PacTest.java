import org.junit.Test;

import static org.junit.Assert.*;

public class PacTest {

    @Test
    public void testcalcularFrete() {
        Pedido pedido = new Pedido();

        pedido.inserirProduto(new Produto("Maçã tailandesa", 16.50, 1));
        pedido.setServicoDeEntrega(new Pac());

        double pesoTotal = pedido.calcularPesoTotal();
        double valorEntregaPac = pedido.getServicoDeEntrega().calcularFrete(pesoTotal);

        assertEquals(15, valorEntregaPac, 0);
    }
}