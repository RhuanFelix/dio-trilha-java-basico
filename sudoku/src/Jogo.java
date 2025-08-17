import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    List<List<Integer>> tabuleiro;
    Random random;

    public Jogo() {
        tabuleiro = new ArrayList<>();
        random = new Random();
    }

    public void preencherTabuleiro() {
        for (int i = 0; i < tabuleiro.size(); i++) {
            for (int j = 0; j < tabuleiro.size(); j++) {
                
            }
        }
    }

    public Integer gerarNumeroAletorioEmUmaPosicao() {
        return random.nextInt(10);
    }

    public void verificarPosicaoValida(int linha, int coluna) {
        
    }
}