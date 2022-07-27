import dom.Veiculo;
import maps.MapLista;
import maps.MapVetor;

public class Main {
	public static MapLista mapalista = new MapLista();
	public static MapVetor mapavetor = new MapVetor();
	
	public static void main(String[] args) {
		/*long a1 = System.currentTimeMillis();
		preencheMapVetor(100000);
		mapavetor.imprimeOrdenado();
		System.out.println("T");
		mapavetor.printAllMarcaFord();
		mapavetor.removeChassiMenorOuIgual(202050000);
		mapavetor.imprimeOrdenado();
		System.out.println((float)(( System.currentTimeMillis() - a1)/ 1000.00 ));*/
		
		long a2 = System.currentTimeMillis();
		preencheMapLista(1000);
		mapalista.imprimeOrdenado();
		System.out.println("T");
		mapalista.printAllMarcaFord();
		mapalista.removeChassiMenorOuIgual(202050000);
		mapalista.imprimeOrdenado();
		System.out.println((float)(( System.currentTimeMillis() - a2)/ 1000.00 ));

	}
	
	public static void preencheMapVetor(int numero) {
		for(int i = 0; i < numero; i++ ) {
			mapavetor.put(new Veiculo());
		}
	}
	public static void preencheMapLista(int numero) {
		for(int i = 0; i < numero; i++ ) {
			mapalista.put(new Veiculo());
		}
	}
}
