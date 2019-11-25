import java.util.Vector;

import grafo.GrafoDinamic;
import grafo.NodoArista;


public class main {

	public static void main(String[] args) {
	GrafoDinamic arbol = new GrafoDinamic();
		arbol.inicializarGrafo();
		arbol.agregarVertice(1);
		arbol.agregarVertice(2);
		arbol.agregarVertice(3);
		arbol.agregarVertice(4);
		arbol.agregarVertice(5);
		arbol.agregarVertice(6);
		arbol.agregarVertice(7);
		arbol.agregarVertice(8);
		arbol.agregarArista(1, 2, 4);
		arbol.agregarArista(1, 3, 8);
		arbol.agregarArista(2, 7, 9);
		arbol.agregarArista(2, 4, 2);
		arbol.agregarArista(2, 5, 7);
		arbol.agregarArista(5, 6, 1);
		arbol.agregarArista(3, 8, 4);
		System.out.println("DFS:");
		arbol.dephtFirstSearch(1);	
		System.out.println();
		System.out.println();
		
	arbol = new GrafoDinamic();
		arbol.agregarVertice(1);
		arbol.agregarVertice(2);
		arbol.agregarVertice(3);
		arbol.agregarVertice(4);
		arbol.agregarVertice(5);
		arbol.agregarVertice(6);
		arbol.agregarVertice(7);
		arbol.agregarVertice(8);
		arbol.agregarVertice(9);
		arbol.agregarVertice(10);
		arbol.agregarArista(1, 2, 8);
		arbol.agregarArista(2, 3, 10);
		arbol.agregarArista(2, 5, 4);
		arbol.agregarArista(4, 3, 5);
		arbol.agregarArista(4, 7, 11);
		arbol.agregarArista(5, 4, 7);
		arbol.agregarArista(5, 6, 2);
		arbol.agregarArista(6, 7, 12);
		arbol.agregarArista(6, 8, 14);
		arbol.agregarArista(6, 9, 6);
		arbol.agregarArista(6, 10, 9);
		arbol.agregarArista(7, 8, 20);
		arbol.agregarArista(8, 9, 17);
		arbol.agregarArista(9, 10, 3);
		System.out.println("PRIM:");
		arbol.PRIM(1, null, false);
		

		/*System.out.println();
		arbol = new GrafoDinamic();
		arbol.agregarVertice(1);
		arbol.agregarVertice(2);
		arbol.agregarVertice(3);
		arbol.agregarVertice(4);
		arbol.agregarVertice(5);
		arbol.agregarArista(1, 3, 5);
		arbol.agregarArista(1, 2, 7);
		arbol.agregarArista(2, 5, 4);
		arbol.agregarArista(3, 5, 10);
		arbol.agregarArista(3, 4, 8);
		arbol.agregarArista(4, 5, 3);*/

		
		arbol = new GrafoDinamic();
		arbol.agregarVertice(1);
		arbol.agregarVertice(2);
		arbol.agregarVertice(3);
		arbol.agregarVertice(4);
		arbol.agregarVertice(5);
		arbol.agregarVertice(6);
		arbol.agregarVertice(7);
		arbol.agregarArista(1, 2, 6);
		arbol.agregarArista(1, 3, 7);
		arbol.agregarArista(1, 4, 7);
		arbol.agregarArista(2, 3, 2);
		arbol.agregarArista(2, 6, 4);
		arbol.agregarArista(3, 4, 1);
		arbol.agregarArista(3, 6, 3);
		arbol.agregarArista(3, 5, 4);
		arbol.agregarArista(4, 5, 3);
		arbol.agregarArista(5, 6, 3);
		arbol.agregarArista(5, 7, 9);
		arbol.agregarArista(6, 7, 6);
		System.out.println();
		System.out.println("DIJSKTRA:");
		imprimirArreglo(arbol.Dijkstra(1, 7));
	}
	
	private static void imprimirArreglo(Vector<NodoArista> aristas) {
		for(int i = aristas.size() - 1; i >= 0; i--)
			System.out.println("De:" + aristas.elementAt(i).getDesde() + ". Hasta:"+aristas.elementAt(i).getHasta()+". Peso:"+aristas.elementAt(i).getPeso());
	}
}
