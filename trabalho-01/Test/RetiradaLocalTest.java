package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.Pedido;
import src.Produto;
import src.RetiradaLocal;

public class RetiradaLocalTest {
    @Test
    public void testCalcularFrete() {
        Pedido pedido = new Pedido();

        pedido.inserirProduto(new Produto("Maçã japonesa", 0.50, 0.485));
        pedido.setServicoDeEntrega(new RetiradaLocal());

        double pesoTotal = pedido.calcularPesoTotal();
        double valorRetirada = pedido.getServicoDeEntrega().calcularFrete(pesoTotal);

        assertEquals(0, valorRetirada, 0);
    }
}
