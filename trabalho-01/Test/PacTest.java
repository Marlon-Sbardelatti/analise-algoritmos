package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.Pac;
import src.Pedido;
import src.Produto;

public class PacTest {

    @Test
    public void testCalcularFrete() {
        Pedido pedido = new Pedido();

        pedido.inserirProduto(new Produto("Maçã tailandesa", 16.50, 1));
        pedido.setServicoDeEntrega(new Pac());

        double pesoTotal = pedido.calcularPesoTotal();
        double valorEntregaPac = pedido.getServicoDeEntrega().calcularFrete(pesoTotal);

        assertEquals(15, valorEntregaPac, 0);
    }
}
