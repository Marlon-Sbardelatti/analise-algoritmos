import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PacTest {

    @Test
    public void testcalcularFrete() {
        Pedido pedido = new Pedido();

        pedido.setNomeCliente("Rosimar");
        pedido.setNumero(1);
        pedido.inserirProduto(new Produto("Maçã tailandesa", 16.50, 1));
        pedido.setServicoDeEntrega(new Pac());

        double pesoTotal = pedido.calcularPesoTotal();
        double valorEntregaPac = pedido.getServicoDeEntrega().calcularFrete(pesoTotal);

        assertEquals(15, valorEntregaPac, 0);
    }
}