import java.text.DecimalFormat;

public class IniciarOperacao {

    public static void inicioOperacao(Maquina maquina){
        maquina.listaMoedas();
        int valorEscolhida = Leitor.lerInteiro(1, 4, "Escolha a opção: ", "Tem de ser um código acima");
        Moeda moeda = maquina.getMoedas().get(valorEscolhida-1);
        maquina.aumentarMoedas(moeda.getValor());

        double valorFinal = moeda.getValor();

        DecimalFormat formatador = new DecimalFormat("0.00");

        Boolean mostrarTroco = false;

        Bebida bebidaEscolhida;


        do {
            maquina.listBebidas();
            int opcaoEscolhida = Leitor.lerInteiro(1000, 9999, "Escolha a opção: ", "Tem de ser um código acima");

            bebidaEscolhida = maquina.getBebidas().get(opcaoEscolhida - 1000);


                if (bebidaEscolhida.getStock() <= 0) {
                    System.out.println("Bebida fora de Stock!");
                } else {
                    System.out.println("O preço da bebida é de: " + bebidaEscolhida.getPreco());
                }

        }while (bebidaEscolhida.getStock() <= 0);

do {
    double dinheiroInserido = 0;
    if (valorFinal < bebidaEscolhida.getPreco()) {
        double precoNescessario = bebidaEscolhida.getPreco() - valorFinal;
        System.out.println("Tem de inserir mais " + formatador.format(precoNescessario) + "€");
        maquina.listaMoedas();
        dinheiroInserido = Leitor.lerInteiro(1, 4, "Escolha a opção: ", "Tem de ser um código acima");
        moeda = maquina.getMoedas().get((int) (dinheiroInserido-1));
        maquina.aumentarMoedas(moeda.getValor());
        valorFinal+= moeda.getValor();

    } else {
        double troco = valorFinal - bebidaEscolhida.getPreco();
        troco = Math.floor(troco*100)/100;
        maquina.aumentarTroco(valorFinal);
        maquina.diminuirTroco(troco);
        Double valorRealmenteFinal = maquina.diminuirMoedas(troco, valorFinal);

        System.out.println("Troco: " + formatador.format(valorRealmenteFinal) + "€");
        bebidaEscolhida.diminuirStock();
        mostrarTroco = true;
    }
}while(!mostrarTroco);





    }


}
