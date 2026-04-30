import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public void inverterPilhaViaReferencial(){
		Celula<E> anterior = fundo;
		Celula<E> atual = topo;
		Celula<E> proximo;

		while (atual != fundo) {
			proximo = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proximo;
		}
		topo = anterior;

	}

	public void inverterPilhaViaPilhaAuxuliar(){
		Pilha<E> pilhaAuxiliar = new Pilha<>(); 
		while (!vazia()) {
			pilhaAuxiliar.empilhar(desempilhar());
		}
		topo = pilhaAuxiliar.topo; 
		fundo = pilhaAuxiliar.fundo;
	}

	public void imprimirPilha(){
		Celula<E> atual = topo;
		
		if (vazia()) {
			System.out.println("A pilha está vazia!");
			return;
		}

		while (atual != fundo) {
			System.out.println(atual.getItem());
			atual = atual.getProximo();
		}
	}

	public void imprimirPilhaInversaRecursiva(){
		imprimirPilhaInversaRecursiva(topo);
	}

	private void imprimirPilhaInversaRecursiva(Celula<E> atual){
		if (atual == fundo){
			return;
		}
		imprimirPilhaInversaRecursiva(atual.getProximo());
		System.out.println(atual.getItem());
	}



	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		// TO-DO
		return null;
	}
}