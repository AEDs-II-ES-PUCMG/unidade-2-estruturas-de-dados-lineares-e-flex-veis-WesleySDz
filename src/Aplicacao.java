public class Aplicacao {

    /////////////////////////////////////////
    ///                Pilha              ///
    /////////////////////////////////////////
    // public static void main(String[] args) {
    //     String numero = "1543817";
    //     Pilha<String> pilha = new Pilha<>();
    //     for (int i = 0; i < numero.length(); i++) {
    //         pilha.empilhar(String.valueOf(numero.charAt(i)));
    //     }
    //     System.err.println("Pilha original:");
    //     pilha.imprimirPilha();
    //     System.err.println("Pilha invertida via pilha auxiliar:");
    //     pilha.inverterPilhaViaPilhaAuxuliar();
    //     pilha.imprimirPilha();

    //     // Desempilhar os itens da pilha
    //     while (!pilha.vazia()) {
    //         pilha.desempilhar();
    //     }
    //     System.err.println("Pilha depois de ser esvaziada:");
    //     pilha.imprimirPilha();
    // }

    public static void main(String[] args) {
        String nome = "WesleyDomingos";
        String nomeFormatado = nome.toLowerCase().trim();
        Fila<Character> fila = new Fila<>();

        for (int i = 0; i < nomeFormatado.length(); i++){
            fila.enfileirar(nomeFormatado.charAt(i));
        }

        char letra = 'w';
        System.err.println("Verificar ocorrencia do " + letra + " :");
        int ocorrencias = fila.contarOcorrencias(letra);
        System.out.println("O caractere '"+ letra + "' ocorre " + ocorrencias + " vezes na fila.");
    }
}
