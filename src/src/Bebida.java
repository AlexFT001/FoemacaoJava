public class Bebida {
    private double preco;
    private StringBuilder nome;
    private int stock;

    private static int numeroInicial = 1000;

    private int numeroPessoal;


    public Bebida(double preco, StringBuilder nome) {
        this.preco = preco;
        this.nome = new StringBuilder(nome);
        this.stock = 20;
        this.numeroPessoal = numeroInicial;
        numeroInicial++;

    }

    public double getPreco() {
        return preco;
    }

    public void diminuirStock() {
        this.stock -= 1;
    }

    @Override
    public String toString() {
        return numeroPessoal + "-" + nome;
    }
}
