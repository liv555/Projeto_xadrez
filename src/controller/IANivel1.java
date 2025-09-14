
package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class IANivel1 {
    private Random random = new Random();

    public Movimento fazerJogada(Tabuleiro tabuleiro, char corJogador) {
        List<Movimento> movimentosValidos = obterTodosMovimentosValidos(tabuleiro, corJogador);
        if (movimentosValidos.isEmpty()) {
            return null; // Não há movimentos possíveis
        }
        // Seleciona um movimento aleatório
        int indiceAleatorio = random.nextInt(movimentosValidos.size());
        return movimentosValidos.get(indiceAleatorio);
    }

    private List<Movimento> obterTodosMovimentosValidos(Tabuleiro tabuleiro, char corJogador) {
        List<Movimento> movimentos = new ArrayList<>();
        char[][] posicoes = tabuleiro.getPosicoes();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char peca = posicoes[i][j];
                if (peca == ' ') continue;

                boolean pecaBranca = Character.isUpperCase(peca);
                if ((corJogador == 'B' && pecaBranca) || (corJogador == 'P' && !pecaBranca)) {
                    // Movimento de teste: tentar andar uma casa pra frente
                    int novaLinha = pecaBranca ? i + 1 : i - 1;
                    if (novaLinha >= 0 && novaLinha < 8 && posicoes[novaLinha][j] == ' ') {
                        movimentos.add(new Movimento(i, j, novaLinha, j));
                    }
                }
            }
        }
        return movimentos;
    }
}

class JogoXadrez {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        IANivel1 ia = new IANivel1();

        System.out.println("Estado inicial do tabuleiro:");
        tabuleiro.imprimirTabuleiro();

        // IA faz um movimento como peças brancas
        System.out.println("\nIA de nível 1 está pensando...");
        Movimento movimento = ia.fazerJogada(tabuleiro, 'B');

        if (movimento != null) {
            System.out.println("Movimento escolhido: " + movimento);
            tabuleiro.executarMovimento(movimento);
            System.out.println("\nTabuleiro após movimento da IA:");
            tabuleiro.imprimirTabuleiro();
        } else {
            System.out.println("IA não conseguiu encontrar um movimento válido.");
        }
    }
}

