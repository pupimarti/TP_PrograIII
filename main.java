import grafo.GrafoDinamic;


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
		arbol.agregarArista(1, 2, 4);
		arbol.agregarArista(1, 5, 5);
		arbol.agregarArista(1, 3, 5);
		arbol.agregarArista(2, 7, 9);
		arbol.agregarArista(2, 4, 5);
		arbol.agregarArista(2, 5, 9);
		arbol.agregarArista(5, 6, 9);
		arbol.dephtFirstSearch(1, null);	
	}
}
