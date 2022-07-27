package maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import dom.Veiculo;

@SuppressWarnings("rawtypes")
public class MapLista implements Map {

	private LDE vetor[] = new LDE[10];
	private int nElementos = 0;

	public MapLista() {
		for (int i = 0; i < 10; i++) {
			vetor[i] = new LDE();
		}
	}

	public int hash(int key) {
		return (int) (((key * 0.63274838) % 1) * vetor.length);
	}

	public void put(Veiculo valor) {
		put(valor.getChassi(), valor);
	}

	public void put(int chave, Veiculo valor) {
		int hash = hash(chave);
		if(vetor[hash].busca(valor.getChassi()) == null)
		vetor[hash(chave)].insereInicio(valor);
	}

	public void remove(int chave) {

		vetor[hash(chave)].remove(chave);
	}

	public Veiculo get(int chave) {
		return vetor[hash(chave)].busca(chave);
	}

	public void reSize() {
		LDE[] aux = vetor;
		LDE[] novo = new LDE[vetor.length * 2];
		this.vetor = novo;
		this.nElementos = 0;
		for (LDE lista : aux) {
			for (int i = 0; i > lista.tamanho(); i++) {
				Veiculo vei = lista.getByIndex(i);
				put(vei);
			}
		}
	}

	public boolean containsKey(int key) {
		return get(key) != null;
	}

	public boolean containsValue(Veiculo value) {
		return get(value.getChassi()) != null;
	}

	@Override
	public int size() {
		return nElementos;
	}

	@Override
	public boolean isEmpty() {
		return nElementos == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < 10; i++) {
			vetor[i] = new LDE();
		}
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		return null;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map m) {

	}

	@Override
	public Set keySet() {
		return null;
	}

	@Override
	public Collection values() {
		return null;
	}

	@Override
	public Set entrySet() {
		return null;
	}

	public void selection_sort(Veiculo[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				int menor = i;
				for (int j = i + 1; j < (vetor.length - 1); j++)
					if (vetor[j] != null)
						if (vetor[j].getChassi() < vetor[menor].getChassi())
							menor = j;
				Veiculo aux = vetor[i];
				vetor[i] = vetor[menor];
				vetor[menor] = aux;
			}
		}
	}

	private Veiculo[] juntaVetor(Veiculo v1[], Veiculo v2[]) {
		Veiculo aux[] = new Veiculo[v1.length + v2.length];
		for (int i = 0; i < v1.length; i++) {
			aux[i] = v1[i];
		}
		for (int i = 0; i < v2.length; i++) {
			aux[i + v1.length] = v2[i];
		}
		return aux;
	}

	public Veiculo[] getVetor() {
		Veiculo[] vetor = new Veiculo[0];
		for (int i = 0; i < this.vetor.length; i++) {
			vetor = juntaVetor(vetor, this.vetor[i].getVetor());
		}
		return vetor;
	}

	public void imprimeOrdenado() {
		int aux = 0;
		Veiculo vetor[] = getVetor();
		selection_sort(vetor);
		for (int i = aux; i < vetor.length; i++)
			if (vetor[i] != null) {
				aux++;
				System.out.println(aux + " - " + vetor[i].toString());
			}
	}

	public void printAllMarcaFord() {
		Veiculo vetor[] = getVetor();
		for (int i = 0; i < vetor.length; i++)
			if (vetor[i] != null)
				if (vetor[i].isMarcaFord())
					System.out.println(vetor[i].toString());
	}

	public void removeChassiMenorOuIgual(int valor) {
		Veiculo vetor[] = getVetor();
		clear();
		for (Veiculo veiculo : vetor) {
			if (veiculo != null)
				if (veiculo.getChassi() > valor)
					put(veiculo.getChassi(), veiculo);
		}
	}
}
