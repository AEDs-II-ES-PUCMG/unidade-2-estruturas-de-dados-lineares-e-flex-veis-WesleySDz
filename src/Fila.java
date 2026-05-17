import java.util.NoSuchElementException;

public class Fila<E> {

    private Celula<E> frente;
    private Celula<E> tras;

    public Fila() {

        Celula<E> sentinela = new Celula<>();
        frente = tras = sentinela;
    }

    public boolean vazia() {

        return (frente == tras);
    }

    public void enfileirar(E item) {

        Celula<E> novaCelula = new Celula<>(item);

        tras.setProximo(novaCelula);
        tras = tras.getProximo();
    }

    public E desenfileirar() {

        E item = null;
        Celula<E> primeiro;

        item = consultarPrimeiro();

        primeiro = frente.getProximo();
        frente.setProximo(primeiro.getProximo());

        primeiro.setProximo(null);

        // Caso o item desenfileirado seja também o último da fila.
        if (primeiro == tras)
            tras = frente;

        return item;
    }

    public E consultarPrimeiro() {

        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        }

        return frente.getProximo().getItem();

    }

    public int tamanhoFila() {
        int count = 0;
        Celula<E> aux = frente.getProximo();

        while (aux != null) {
            count++;
            aux = aux.getProximo();
        }

        return count;
    }

    public Fila<E> copiarFila() {
        Fila<E> novaFila = new Fila<>();
        Celula<E> aux = frente.getProximo();

        while (aux != null) {
            novaFila.enfileirar(aux.getItem());
            aux = aux.getProximo();
        }

        return novaFila;
    }

    public boolean verificarExistencia(E item) {
        Celula<E> aux = frente.getProximo();

        while (aux != null) {
            E itemAux = aux.getItem();

            if (item == itemAux) {
                return true;
            }

            aux = aux.getProximo();
        }

        return false;
    }

    public int contarOcorrencias(E item) {
        int count = 0;
        Celula<E> aux = frente.getProximo();

        while (aux != null) {
            E itemAux = aux.getItem();
            if (itemAux == item) {
                count++;
            }
            aux = aux.getProximo();
        }

        return count;
    }

    public Fila<E> dividirFila() {
        Fila<E> filaPares = new Fila<>();
        int tamanho = tamanhoFila();

        for (int posicao = 0; posicao < tamanho; posicao++) {
            E item = desenfileirar();
            if (posicao % 2 == 0) {
                filaPares.enfileirar(item);
            } else {
                enfileirar(item);
            }
        }

        return filaPares;
    }

    public void imprimir() {

        Celula<E> aux;

        if (vazia()) {
            throw new NoSuchElementException("Não há itens na fila para imprimir!");
        }
        aux = this.frente.getProximo();
        while (aux != null) {
            System.out.println(aux.getItem());
            aux = aux.getProximo();
        }
    }

    public void inverterFilaViaReferencial() {
        Celula<E> anterior = null;
        Celula<E> atual = frente.getProximo();
        Celula<E> proximo;

        while (atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(anterior);
            anterior = atual;
            atual = proximo;
        }

        // Após a inversão, o antigo primeiro elemento se torna o último, e o antigo
        // último se torna o primeiro.
        tras = frente.getProximo(); // O antigo primeiro elemento agora é o último
        frente.setProximo(anterior); // O antigo último elemento agora é o primeiro
    }

    public void inverterFilaViaFilaAuxiliar() {
        Fila<E> filaAuxiliar = new Fila<>();

        int tamanho = tamanhoFila();

        // Desenfileirar os elementos da fila original e enfileirar na fila auxiliar
        for (int i = 0; i < tamanho; i++) {
            // Para cada elemento, desenfileira da fila original e enfileira na fila
            // auxiliar
            for (int j = 0; j < tamanho - i - 1; j++) {
                this.enfileirar(this.desenfileirar());
            }

            filaAuxiliar.enfileirar(this.desenfileirar());
        }

        // Transferir os elementos da fila auxiliar de volta para a fila original
        while (!filaAuxiliar.vazia()) {
            this.enfileirar(filaAuxiliar.desenfileirar());
        }

    }

    public void inverterFilaViaPilhaAuxiliar() {
        Pilha<E> pilhaAuxiliar = new Pilha<>();

        // Desenfileirar os elementos da fila original e empilhar na pilha auxiliar
        while (!this.vazia()) {
            pilhaAuxiliar.empilhar(this.desenfileirar());
        }

        // Desempilhar os elementos da pilha auxiliar e enfileirar de volta na fila
        // original
        while (!pilhaAuxiliar.vazia()) {
            this.enfileirar(pilhaAuxiliar.desempilhar());
        }
    }

    public Fila<E> extrairLote(int numItens) {
        Fila<E> filaExtraida = new Fila<>();
        int itensExtraidos = 0;

        if (vazia()) {
            throw new NoSuchElementException("Não há itens na fila para extrair!");
        }

        // Desenfileira da fila original enquanto houver itens E o limite (numItens) não
        // for atingido
        while (!this.vazia() && itensExtraidos < numItens) {
            filaExtraida.enfileirar(this.desenfileirar());
            itensExtraidos++;
        }

        return filaExtraida;
    }

    // Testar extrair lote
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        fila.enfileirar(5);

        System.err.println("Fila original:");
        fila.imprimir();

        // Testar copiar fila
        System.err.println("Fila copiada:");
        Fila<Integer> filaCopiada = fila.copiarFila();
        filaCopiada.imprimir();

        int numItens = 1;
        Fila<Integer> loteExtraido = fila.extrairLote(numItens);

        System.err.println("Lote extraído:");
        loteExtraido.imprimir();

        // Testar inversão da fila
        System.err.println("Fila original antes da inversão:");
        fila.imprimir();
        fila.inverterFilaViaReferencial();
        System.err.println("Fila original após a inversão:");
        fila.imprimir();

    }
}