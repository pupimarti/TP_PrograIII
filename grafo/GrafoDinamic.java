package grafo;

import java.util.Vector;

public class GrafoDinamic implements TDAGrafo {
		NodoGrafo nodo;
		int cantidad;

		public void inicializarGrafo() {
			nodo = null;
			cantidad = 0;
		}
		public void eliminarVertice(int v) {
			NodoGrafo aux = encontrarNodo(v);
			
			if(aux != null) {
				aux = nodo; 
				if(aux.valor == v) {
					nodo = aux.sig;
					System.out.println("1");
				}
				while(aux != null) {
					this.eliminarArista(aux.valor, v);	
					if(aux.sig == this.encontrarNodo(v) && aux.sig != null) {
						aux.sig = aux.sig.sig;
						cantidad--;
						System.out.println("1");
					}
						aux = aux.sig;
						System.out.println("2");
				}
				
			}else {
				System.out.println("El vertice no existe");
			}

			
		}

		public void agregarVertice(int v) {
			if(this.encontrarNodo(v) == null) {
				
			
				NodoGrafo aux = new NodoGrafo();
				aux.valor = v;
				aux.lista = null;
				aux.sig = nodo;
				aux.marcado = false;
				nodo = aux;
				cantidad++;
			}	
				
		}

		
		public int[] vertices() {
			
			return null;
		}

		public void agregarArista(int v1, int v2, int peso) {
			if(this.encontrarNodo(v1) != null && this.encontrarNodo(v2) != null) {
				NodoArista aux = new NodoArista();
				aux.origen = v1;
				aux.peso = peso;
				aux.apunta = this.encontrarNodo(v2);
				aux.sig = encontrarNodo(v1).lista;
				aux.marcado = false;
				encontrarNodo(v1).lista = aux; 
				NodoArista aux2 = new NodoArista();
				aux2.origen = v2;
				aux2.peso = peso;
				aux2.apunta = this.encontrarNodo(v1);
				aux2.sig = encontrarNodo(v2).lista;
				aux2.marcado = false;
				encontrarNodo(v2).lista = aux2; 
			}else {
				System.out.println("No existe alguino de los nodos");
			}
		}
		

		
		public void eliminarArista(int v1, int v2) {
			NodoGrafo nodo = encontrarNodo(v1);
			NodoArista arista = nodo.lista;
			if(arista != null) {
				if(arista.apunta.valor == v2) {				
					nodo.lista = arista.sig;
				}
				else {
					while(arista.sig != null && arista.apunta.valor == v2) {
						arista = arista.sig;
					}
					if(arista.sig != null) {
						arista.sig = arista.sig.sig;
					}				
				}			
			}
		}
		
		public boolean existeArista(int v1, int v2) {
			NodoGrafo aux = this.encontrarNodo(v1);
			NodoArista arista = aux.lista ;
			while(arista != null) {
				if(arista.apunta.valor ==v2) {
					return true;
				}
				arista = arista.sig;
			}		
			return false;
		}

		public int pesoArista(int v1, int v2) {
			// TODO Auto-generated method stub
			return 0;
		}


		public void mostrarMatriz() {
			NodoGrafo aux = nodo;
			NodoArista arista;
			while(aux != null) {
			System.out.print(aux.valor + "\t" );
			arista = aux.lista;
				while(arista != null) {
					
					System.out.print(arista.peso + " "  + arista.apunta.valor +  "\t");
					arista = arista.sig;
				}
				System.out.println();
				aux = aux.sig;
			}
		}

		public boolean pertenece(int x) {
			if (this.encontrarNodo(x) != null) {
				return true;
			}
			return false;
		}

		public int mayorArista(int v) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int[] conjuntoAislados() {
			int aislados[]= new int [cantidad];
			NodoGrafo aux = nodo;
			
			while(aux != null) {
				
			}
			return null;
		}

		public void imparAristas() {
			// TODO Auto-generated method stub
			
		}
		
		public NodoGrafo encontrarNodo(int v) {
			NodoGrafo aux = nodo;
			while(aux != null) {
				if(aux.valor == v) {
					return aux;
				}
				aux = aux.sig;
			}
			return null;
		}

		public int[] dephtFirstSearch(int v1, Vector<Integer> visitados) {
			NodoGrafo aux = encontrarNodo(v1);
			int[] vector_ady = adyacencias(aux.valor);
			if(visitados == null) {
				visitados = new Vector<Integer>();
			}
			visitados.add(v1);
			if(vector_ady != null) {
				for(int i = vector_ady.length - 1; i >= 0 ; i--) {
					if(!existeEnVisitados(vector_ady[i], visitados))
						dephtFirstSearch(vector_ady[i], visitados);
				}
			}
			System.out.println(v1);
			
			return null;
		}
		
		public boolean existeEnVisitados(int v, Vector<Integer> visitados) {
				for(Integer t : visitados) {
					if(t == v)
						return true;
				}
			return false;
		}
		
		public int[] adyacencias(int v1) {
			NodoGrafo aux = encontrarNodo(v1);
			NodoArista arista = aux.lista;
			int[] ady = new int[100];
			int i = 0;
			while(arista != null) {
				ady[i] = arista.apunta.valor;
				arista = arista.sig;
				i++;
			}
			int[] result = new int [i];
			for(int j = 0; j < i; j++) {
				result[j] = ady[j];
			}
			return result;
		}
		public Vector<NodoArista> adyacenciasNodo(int v1) {
			NodoGrafo aux = encontrarNodo(v1);
			NodoArista arista = aux.lista;
			Vector<NodoArista> aristas = new Vector<NodoArista>();
			while(arista != null && arista.origen == v1) {
				aristas.add(arista);
				arista = arista.sig;
			}
			return aristas;
		}
		
		private NodoArista devolverMenorSinMarcar(Vector<NodoArista> aristas) {
			
			NodoArista menor = null;
			NodoGrafo grafo = null;
			for(NodoArista arista : aristas) {
				grafo = encontrarNodo(arista.origen);
				if(grafo.marcado) {
					if(!arista.apunta.marcado && menor == null) {
						menor = arista;
					}else if(!arista.apunta.marcado){
						if(arista.peso < menor.peso)
							menor = arista;
					}
				}
			}
			return menor;
		}
		
		public void PRIM(int v, Vector<NodoArista> noUtilizadas, boolean repitiendo) {
			// TODO Auto-generated method stub
			NodoGrafo aux = encontrarNodo(v);//encuentro nodo
			NodoArista menor = null;

			Vector<NodoArista> aristas = adyacenciasNodo(aux.valor); //Si no esta repitiendo las aristas son las adyacencias
			if(repitiendo) 
				aristas.addAll(noUtilizadas);//Si esta repitiendo las le sumo noUtilizadas a aristas

			aux.marcado = true;	 //marco el nodo
			menor = devolverMenorSinMarcar(aristas); //Obtengo del arreglo aristas el menor sin marcar que apunte a nodo sin marcar 
			
			if(menor != null) {
				menor.marcado = true; //Si hay menor lo marco
				
				if(noUtilizadas == null) {
					noUtilizadas = new Vector<NodoArista>(); 
				}
				for(NodoArista arista : aristas) {
					if(arista.marcado == false && !noUtilizadas.contains(arista))//Si la arista no esta marcada y noUtilizadas no contiene esta arista
						noUtilizadas.add(arista);//agrego la arista
					}
				if(!repitiendo)
					noUtilizadas.remove(menor); //Si estoy repitiendo remuevo la arista de noUtilizadas
				
				
				System.out.println("De:" +menor.origen+ " A: " +menor.apunta.valor + ". Peso: "+menor.peso);
				
				PRIM(menor.apunta.valor, noUtilizadas, repitiendo);
			}else {
				menor = devolverMenorSinMarcar(noUtilizadas);
				if(menor != null)
					PRIM(menor.origen, noUtilizadas, true);
			}
			return;
		}

}