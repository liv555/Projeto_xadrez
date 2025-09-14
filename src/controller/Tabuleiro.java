package controller;

public class Tabuleiro {
    private char[][] posicoes = new char[8][8];

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.imprimirTabuleiro();
    }

    public Tabuleiro() {
        // Inicialização do tabuleiro
        // Peças brancas
        posicoes[0] = new char[]{'T','C','B','D','R','B','C','T'};
        posicoes[1] = new char[]{'P','P','P','P','P','P','P','P'};
        // Espaços vazios
        for (int i = 2; i < 6; i++) {
            posicoes[i] = new char[]{' ',' ',' ',' ',' ',' ',' ',' '};
        }
        // Peças pretas
        posicoes[6] = new char[]{'p','p','p','p','p','p','p','p'};
        posicoes[7] = new char[]{'t','c','b','d','r','b','c','t'};
    }

    public void imprimirTabuleiro() {
        System.out.println(" a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(posicoes[i][j] + " ");
            }
            System.out.println(8-i);
        }
        System.out.println(" a b c d e f g h");
    }

    public void executarMovimento(Movimento movimento) {
        char peca = posicoes[movimento.getLinhaOrigem()][movimento.getColunaOrigem()];
        posicoes[movimento.getLinhaOrigem()][movimento.getColunaOrigem()] = ' ';
        posicoes[movimento.getLinhaDestino()][movimento.getColunaDestino()] = peca;
    }

    public char[][] getPosicoes() {
        return posicoes;
    }
}
