import org.junit.Test;

import static org.junit.Assert.assertEquals;

import src.Pedido;
import src.Produto;
import src.Sedex;

public class SedexTest {
    @Test
    public void testCalcularFrete() {
        Pedido pedido = new Pedido();

        pedido.inserirProduto(new Produto("Laranja tailandesa", 193436.50, 6));
        pedido.setServicoDeEntrega(new Sedex());

        double pesoTotal = pedido.calcularPesoTotal();
        double valorEntregaSedex = pedido.getServicoDeEntrega().calcularFrete(pesoTotal);

        assertEquals(106.5, valorEntregaSedex, 0);
    }
}
