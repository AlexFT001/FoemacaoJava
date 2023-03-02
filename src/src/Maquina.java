import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Maquina {
    private LinkedList<Bebida> bebidas;
    private double troco;

    private  LinkedList<Moeda> moedas;

    //private LinkedHashMap<Moeda, Integer> moeda;

    private int contador5;
    private int contador10;
    private int contador20;
    private int contador50;


    public Maquina(){
        this.bebidas =new LinkedList<>();
        this.moedas = new LinkedList<>();
        //this.moeda = new LinkedHashMap<>();
        this.contador5 = 5;
        this.contador10 = 5;
        this.contador20 = 5;
        this.contador50 = 5;
    }


    public void addBebidas(Bebida bebida){
        this.bebidas.add(bebida);
    }
    public void addMoedas(Moeda moedas){
        this.moedas.add(moedas);
    }

    /*public void addmoeda(Moeda moeda){
      this.moeda.put(moeda, 5);
    }*/

    public void aumentarTroco(double valor){
        this.troco+=valor;
    }

    public void diminuirTroco(double valor){
        this.troco-=valor;
    }

    public LinkedList<Bebida> getBebidas() {
        return bebidas;
    }

    public LinkedList<Moeda> getMoedas() {
        return moedas;
    }

    /*public LinkedHashMap<Moeda, Integer> getMoeda() {
        return moeda;
    }*/

    public void listBebidas(){
        for(Bebida bebida : this.bebidas){
            System.out.println(bebida);
        }
    }

    public void listaMoedas(){
        int i = 1;
        for(Moeda moeda : this.moedas){
            System.out.println(i +". "+moeda + "€");
            i++;
        }
    }

    /*public void listaMoeda(){
        int i = 1;
        for(var moeda : moeda.entrySet()){
            System.out.println(i+". " +moeda.getKey()+"€");
            i++;
        }

    }*/

    public double diminuirMoedas(double valor, double valorFinal) {


        float trocoDevolvido = (float) valor;
        double valorDevolver = 0;
        if (this.contador5 == 0 || this.contador10 == 0 || this.contador20 == 0 || this.contador50 == 0) {
            System.out.println("Não existe Troco");
            valorDevolver = valorFinal - valor;
            diminuirTroco(valorDevolver);
        } else {
            do {
                if (trocoDevolvido >= 0.50 && trocoDevolvido - 0.50 > 0) {
                    this.contador50 -= 1;
                    trocoDevolvido -= 0.5;
                    trocoDevolvido = (float) Math.round(trocoDevolvido * 100) / 100;
                    valorDevolver += 0.50;
                } else if (trocoDevolvido >= 0.20 && trocoDevolvido - 0.20 > 0) {
                    this.contador20 -= 1;
                    trocoDevolvido -= 0.2;
                    trocoDevolvido = (float) Math.round(trocoDevolvido * 100) / 100;
                    valorDevolver += 0.20;
                } else if (trocoDevolvido >= 0.10 && trocoDevolvido - 0.10 > 0) {
                    this.contador10 -= 1;
                    trocoDevolvido -= 0.1;
                    trocoDevolvido = (float) Math.round(trocoDevolvido * 100) / 100;
                    valorDevolver += 0.10;
                } else if (trocoDevolvido >= 0.05 && trocoDevolvido - 0.05 > 0) {
                    this.contador5 -= 1;
                    trocoDevolvido -= 0.05;
                    trocoDevolvido = (float) Math.round(trocoDevolvido * 100) / 100;
                    valorDevolver += 0.05;
                }
            } while (trocoDevolvido != 0);

        }
        return  valorDevolver;
    }

    public void aumentarMoedas(/*Moeda moedaRecebida*/ double valor){
        //moeda.put(moedaRecebida, moeda.get(moedaRecebida) + 1);

       if(valor == 0.05){
            this.contador5 += 1;
        } else if (valor == 0.10) {
            this.contador10 += 1;
        } else if (valor == 0.20) {
            this.contador20+=1;
        } else if (valor == 0.50) {
            this.contador50 += 1;
        }

    }

    public void resetarMaquina(){
        this.moedas.clear();
        this.bebidas.clear();
        this.contador5 = 5;
        this.contador10 = 5;
        this.contador20 = 5;
        this.contador50 = 5;
    }


}
