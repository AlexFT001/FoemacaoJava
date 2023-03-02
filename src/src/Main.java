public class Main {
    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        Bebida cocaCola = new Bebida(0.70, new StringBuilder("Coca-Cola"));
        Bebida pepsi = new Bebida(0.65, new StringBuilder("Pepsi"));
        Bebida iceTea = new Bebida(0.60, new StringBuilder("Ice Tea"));
        Moeda cinco = new Moeda(0.05);
        Moeda dez = new Moeda(0.10);
        Moeda vinte = new Moeda(0.20);
        Moeda cinquenta = new Moeda(0.50);

        maquina.addBebidas(cocaCola);
        maquina.addBebidas(pepsi);
        maquina.addBebidas(iceTea);

        maquina.addMoedas(cinco);
        maquina.addMoedas(dez);
        maquina.addMoedas(vinte);
        maquina.addMoedas(cinquenta);

        int opcao;

        do{
            opcao = menu();
            switch (opcao){
                case 1:
                    IniciarOperacao.inicioOperacao(maquina);
                    break;
                case 2:
                    break;
                default:
                    maquina.resetarMaquina();

                    maquina.addBebidas(cocaCola);
                    maquina.addBebidas(pepsi);
                    maquina.addBebidas(iceTea);

                    maquina.addMoedas(cinco);
                    maquina.addMoedas(dez);
                    maquina.addMoedas(vinte);
                    maquina.addMoedas(cinquenta);
                    break;
            }
        }while (opcao != 2);



    }

    public static int menu(){
        System.out.println("Deseja realizar uma compra?");
        System.out.println("1.Sim");
        System.out.println("2.Não");
        return Leitor.lerInteiro(1,5,"Escolha a Opção: ", "O número tem de estar entre 1 e 2");

    }
}