public class Aplicacao {
    public static void main(String[] args) {
        String numero = "1543817";
        Pilha<String> pilha = new Pilha<>();
        for (int i = 0; i < numero.length(); i++) {
            pilha.empilhar(String.valueOf(numero.charAt(i)));
        }
        System.err.println("Pilha original:");
        pilha.imprimirPilha();
        System.err.println("Pilha invertida via pilha auxiliar:");
        pilha.inverterPilhaViaPilhaAuxuliar();
        pilha.imprimirPilha();

        // Desempilhar os itens da pilha
        while (!pilha.vazia()) {
            pilha.desempilhar();
        }
        System.err.println("Pilha depois de ser esvaziada:");
        pilha.imprimirPilha();
    }
}
