public class Main {
    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        Bebida cocaCola = new Bebida(0.70, new StringBuilder("Coca-Cola"));
        Bebida pepsi = new Bebida(0.65, new StringBuilder("Pepsi"));
        Bebida iceTea = new Bebida(0.60, new StringBuilder("Ice Tea"));

        maquina.addBebidas(cocaCola);
        maquina.addBebidas(pepsi);
        maquina.addBebidas(iceTea);

        int opcao;

        do{
            opcao = menu();
            if(opcao == 1){
            IniciarOperacao.inicioOperacao(maquina);
            }
        }while (opcao != 2);



    }

    public static int menu(){
        System.out.println("Deseja realizar uma compra?");
        System.out.println("1.Sim");
        System.out.println("2.Não");
        return Leitor.lerInteiro(1,2,"Escolha a Opção: ", "O número tem de estar entre 1 e 2");

    }
}