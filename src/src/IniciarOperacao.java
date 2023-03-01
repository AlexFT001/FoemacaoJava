public class IniciarOperacao {

    public static void inicioOperacao(Maquina maquina){
        double valorFinal = 0;



        maquina.listBebidas();
        int opcaoEscolhida = Leitor.lerInteiro(1000, 2000, "Escolha a opção: ", "Tem de ser um código acima");

        Bebida bebidaEscolhida = maquina.getBebidas().get(opcaoEscolhida-1000);

        System.out.println("O preço da bebida é de: " + bebidaEscolhida.getPreco());

do {
    double opcaoValor = menuDinheiro();
    valorFinal +=opcaoValor;
    if (valorFinal < bebidaEscolhida.getPreco()) {
        double precoNescessario = bebidaEscolhida.getPreco() - valorFinal;
        System.out.println("Tem de inserir mais " + precoNescessario + "€");
    } else {
        maquina.aumentarTroco(bebidaEscolhida.getPreco());
        double troco = valorFinal - bebidaEscolhida.getPreco();
        System.out.println("Troco: " + troco + "€");
    }
}while(valorFinal<bebidaEscolhida.getPreco());





    }

    private static double menuDinheiro(){
        System.out.println("Quanto deseja Inserir: ");
        System.out.println("1.  0,05€");
        System.out.println("2.  0,10€");
        System.out.println("3.  0,20€");
        System.out.println("4.  0,50€");
       return Leitor.lerInteiro(1, 4,"Escolha a opção", "A opção tem de estar entre 1 e 4");
    }
}
