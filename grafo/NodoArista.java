package grafo;

import java.util.Comparator;

public class NodoArista implements Comparable<NodoArista>{
	int peso;
	NodoArista sig;
	NodoGrafo apunta;
	int origen;
	boolean marcado;
	
	public int compareTo(NodoArista aux) {
		if(this.peso < aux.peso) {
			return -1;
		}else if(this.peso > aux.peso) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int getPeso() {
		return peso;
	}
	
	public int getDesde() {
		return origen;
	}
	
	public int getHasta() {
		return apunta.valor;
	}

}
