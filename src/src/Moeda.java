public class Moeda {

    private double valor;

    public Moeda(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "" + valor;
    }
}
