import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private Acao acao;
    private Investidor marlon;
    private Investidor sara;
    private Investidor sofia;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        acao = new Acao("Banco do Brasil", 20);
        marlon = new Investidor("Marlon");
        sara = new Investidor("Sara");
        sofia = new Investidor("Sofia");
    }

    @Test
    public void testConstrutor() {
        assertEquals("Banco do Brasil", acao.getNome());
        assertEquals(20, acao.getValor(), 0);
        assertNotNull(acao.getInvestidoresInscritos());
        assertNotNull(acao.getRegistrosPendentes());
        assertNotNull(acao.getOrdens());
    }

    @Test
    public void testSetNomeAcao() {
        acao.setNome("NovoNome");
        assertEquals("NovoNome", acao.getNome());
    }

    @Test
    public void testSetValor() {
        acao.setValor(150.0);
        assertEquals(150.0, acao.getValor(), 0);
    }

    @Test
    public void testCriacaoAcao() {
        assertEquals("Banco do Brasil", acao.getNome());
        assertEquals(20, acao.getValor(), 0);
    }

    @Test
    public void testAgendarOrdemCompraInvestidor() {
        marlon.agendarOrdemCompra(acao, 80, 70);
        assertFalse(acao.getRegistrosPendentes().isEmpty());
    }

    @Test
    public void testValorAcaoAtualizado() {
        sara.registrarOrdemVenda(acao, 24);
        sofia.registrarOrdemCompra(acao, 24);
        assertEquals(24, acao.getValor(), 0);
    }

    @Test
    public void testInvestidorRecebeVariasNotificacoes() {
        marlon.inscreverSeEmAcao(acao);

        outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        DecimalFormat df = new DecimalFormat("0.00");
        String esperado = "Marlon, a ação Banco do Brasil teve seu valor atualizado para R$ "
                + df.format(21) + System.lineSeparator();
        esperado += "Marlon, a ação Banco do Brasil teve seu valor atualizado para R$ "
                + df.format(22) + System.lineSeparator();

        sara.registrarOrdemVenda(acao, 21);
        sofia.registrarOrdemCompra(acao, 21);

        sara.registrarOrdemVenda(acao, 22);
        sofia.registrarOrdemCompra(acao, 22);

        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void testConstrutorInvestidor() {
        assertEquals("Marlon", marlon.getNome());
    }

    @Test
    public void testConstrutorInvestidorNomeIncorreto() {
        assertNotEquals("Marlon", sofia.getNome());
    }

    @Test
    public void testSetNome() {
        marlon.setNome("Maria");
        assertEquals("Maria", marlon.getNome());
    }

    @Test
    public void testInscreverSeEmAcao() {
        marlon.inscreverSeEmAcao(acao);
        assertTrue(acao.getInvestidoresInscritos().contains(marlon));
    }

    @Test
    public void testAgendarValorAtual() {
        marlon.inscreverSeEmAcao(acao);

        marlon.agendarOrdemCompra(acao, 25, 20);

        OrdemComum ordemEsperada = new OrdemComum("Marlon", 25);
        ordemEsperada.setTipo(TipoOrdem.COMPRA);

        OrdemComum ordemAtual = (OrdemComum) acao.getOrdens().get(0);

        assertEquals(ordemAtual.toString(), ordemEsperada.toString());
    }

    @Test
    public void testAtualizarValorAcao() {
        DecimalFormat df = new DecimalFormat("0.00");
        String esperado = "Marlon, a ação Nu Bank teve seu valor atualizado para R$ "
                + df.format(150) + System.lineSeparator();

        outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        acao.setNome("Nu Bank");
        marlon.inscreverSeEmAcao(acao);
        sara.registrarOrdemVenda(acao, 150);
        sofia.registrarOrdemCompra(acao, 150);

        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void testAtualizarValorAcao1() {
        DecimalFormat df = new DecimalFormat("0.00");
        String esperado = "Marlon, a ação PETR4 teve seu valor atualizado para R$ "
                + df.format(300) + System.lineSeparator();

        outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        acao.setNome("PETR4");
        marlon.inscreverSeEmAcao(acao);
        sara.registrarOrdemVenda(acao, 300);
        sofia.registrarOrdemCompra(acao, 300);

        assertEquals(esperado, outContent.toString());
    }

}
