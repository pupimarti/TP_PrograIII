package grafo;

import java.util.Vector;

public interface TDAGrafo {
	
	public void inicializarGrafo();
	
	public void eliminarVertice(int v);
	
	public void agregarVertice(int v) ;
		
	public int [] vertices();
	
	public void agregarArista(int v1, int v2, int peso);
	
	public void eliminarArista(int v1, int v2);
	
	public boolean existeArista(int v1, int v2);
	
	public int pesoArista(int v1, int v2);
	
	public void mostrarMatriz();
	
	public boolean pertenece(int x);
	
	public int mayorArista(int v);
	
	public int[] conjuntoAislados();
	
	public void imparAristas();
	
	public int[] dephtFirstSearch(int v1);
	
	public void PRIM(int v, Vector<NodoArista> noUtilizadas, boolean repitiendo);
	
	public Vector<NodoArista> Dijkstra(int v1, int v2);
	
}