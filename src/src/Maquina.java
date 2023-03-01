import java.util.LinkedList;

public class Maquina {
 private LinkedList<Bebida> bebidas;
 private double troco;

 public Maquina(){
     this.bebidas =new LinkedList<>();
 }


 public void addBebidas(Bebida bebida){
     this.bebidas.add(bebida);
 }

 public void aumentarTroco(double valor){
     this.troco+=valor;
 }

    public void diminuirTroco(double valor){
        this.troco-=valor;
    }

    public LinkedList<Bebida> getBebidas() {
        return bebidas;
    }

    public void listBebidas(){
     for(Bebida bebida : this.bebidas){
         System.out.println(bebida);
     }
    }

}
