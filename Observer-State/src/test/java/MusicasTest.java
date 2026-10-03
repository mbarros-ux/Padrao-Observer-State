// Arquivo: MusicasTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicasTest {

    private Musicas musicas;
    private ObservadorStub observadorStub;

    @BeforeEach
    public void setUp() {
        musicas = new Musicas("MusicaTeste");
        observadorStub = new ObservadorStub();
        musicas.adicionarObservador(observadorStub);
    }

    @Test
    public void testEstadoInicial() {
        assertEquals("Musica (Parada)", musicas.getNomeEstadoAtual());
    }

    @Test
    public void testTransicaoInicialParaTocando() {
        boolean resultado = musicas.tocar();
        assertTrue(resultado);
        assertEquals("Tocando", musicas.getNomeEstadoAtual());
    }

    @Test
    public void testTransicaoTocandoParaPausado() {
        musicas.tocar();
        boolean resultado = musicas.pausar();
        assertTrue(resultado);
        assertEquals("Pausado", musicas.getNomeEstadoAtual());
    }

    @Test
    public void testTransicaoInvalidaPausarNoEstadoInicial() {
        boolean resultado = musicas.pausar();
        assertFalse(resultado);
        assertEquals("Musica (Parada)", musicas.getNomeEstadoAtual());
    }

    @Test
    public void testTransicaoInvalidaTocarNoEstadoDeletado() {
        musicas.deletar();
        boolean resultado = musicas.tocar();
        assertFalse(resultado);
        assertEquals("Deletado", musicas.getNomeEstadoAtual());
    }

    @Test
    public void testObserverEhNotificadoNaMudancaDeEstado() {
        musicas.tocar();
        assertEquals(1, observadorStub.getQuantidadeDeNotificacoes());
        assertEquals("MusicaTeste", observadorStub.getUltimoNomeRecebido());
        assertEquals("Tocando", observadorStub.getUltimoEstadoRecebido());
    }

    @Test
    public void testObserverNaoEhNotificadoEmTransicaoInvalida() {
        musicas.pausar();
        assertEquals(0, observadorStub.getQuantidadeDeNotificacoes());
        assertNull(observadorStub.getUltimoEstadoRecebido());
    }

    @Test
    public void testObserverEhNotificadoMultiplasVezes() {
        musicas.tocar();
        musicas.pausar();
        musicas.deletar();
        assertEquals(3, observadorStub.getQuantidadeDeNotificacoes());
        assertEquals("Deletado", observadorStub.getUltimoEstadoRecebido());
    }
}