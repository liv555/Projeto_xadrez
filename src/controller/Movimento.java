package controller;
public class Movimento {
    private int linhaOrigem;
    private int colunaOrigem;
    private int linhaDestino;
    private int colunaDestino;

    public Movimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        this.linhaOrigem = linhaOrigem;
        this.colunaOrigem = colunaOrigem;
        this.linhaDestino = linhaDestino;
        this.colunaDestino = colunaDestino;
    }

    public int getLinhaOrigem() { return linhaOrigem; }
    public int getColunaOrigem() { return colunaOrigem; }
    public int getLinhaDestino() { return linhaDestino; }
    public int getColunaDestino() { return colunaDestino; }

    @Override
    public String toString() {
        char colunaOrigemChar = (char) ('a' + colunaOrigem);
        char colunaDestinoChar = (char) ('a' + colunaDestino);
        return "" + colunaOrigemChar + (8 - linhaOrigem) +
            "-" + colunaDestinoChar + (8 - linhaDestino);
    }
}
