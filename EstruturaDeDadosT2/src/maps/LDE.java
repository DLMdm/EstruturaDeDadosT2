package maps;

import dom.Veiculo;

public class LDE implements Lista {
	private Noh inicio;
	private Noh fim;
	private int tamanho;

	public LDE() {
		this.inicio = null;
		this.fim = null;
		tamanho = 0;
	}

	public void insereInicio(Veiculo info) {
		Noh novo = new Noh(info);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
			tamanho ++;
		} else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
			tamanho ++;
		}
	}

	public boolean estahVazia() {
		return inicio == null;
	}

	@Override
	public void insereFim(Veiculo info) {
		Noh novo = new Noh(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
			tamanho ++;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
			tamanho ++;
		}
	}

	public boolean remove(int info) {
		Noh p = buscaf(info);
		if (p == null)
			return false;
		if (p.getAnt() == null) {
			inicio = p.getProx();
			inicio.setAnt(null);
			tamanho --;
		} else if (p.getProx() == null) {
			p.getAnt().setProx(null);
			fim = p.getAnt();
			tamanho --;
		} else {
			p.getAnt().setProx(p.getProx());
			p.getProx().setAnt(p.getAnt());
			tamanho --;
		}
		return true;
	}

	public Veiculo busca(int info) {
		Noh v = buscaf(info);
		if(v == null) {
			return null;
		}
		return v.getInfo();
	}

	private Noh buscaf(int info) {
		for (Noh i = inicio; i != null && i.getInfo().getChassi() != info; i = i.getProx()) {
			if (i.getInfo().getChassi() == info)
				return i;
		}
		return null;
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	public void imprimeInicioAFim() {
		for (Noh i = inicio; i != null; i = i.getProx())
			System.out.println(i.toString() + "\n");
	}

	public void imprimeFimAInicio() {
		for (Noh i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}

	public Veiculo getByIndex(int index) {
		int aux = 0;
		for (Noh i = inicio; i != null; i = i.getProx()) {
			if (index == aux)
				return i.getInfo();
		}
		return null;
	}
	
	public Veiculo[] getVetor() {
		int aux = 0;
		Veiculo vei[] = new Veiculo[this.tamanho];
		for (Noh i = inicio; i != null; i = i.getProx()) {
			vei[aux] = i.getInfo();
			aux ++;
		}
		return vei;
	}

	@Override
	public void imprime() {
		// TODO Auto-generated method stub
		
	}


}
