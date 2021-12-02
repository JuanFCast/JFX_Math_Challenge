package model;

/*
 * Añadir (Para añadir cada jugador al arbol binario)			 ya
 * Eliminar (Para borrar determinado jugador)
 * Buscar (Para buscar un jugador especifico)					 ya 
 * Retornar un arreglo con los primeros 5 jugadores
 * Retornar la posicion del jugador que esta jugando
 * Leer cada jugador del docs que los guardara
 * Guardar los jugadores que esten en el arbol binario en un doc
 * 
 * */

public class ScoreBoard {
	
	private Player root;
	
	public ScoreBoard() {
		
	}
	
	public void addChallenger(Player n) {
		if(root == null) {
			root = n;
		} else {
			addChallenger(n, root);
		}
	}
	
	
	//Para este caso manejaremos puntajes menores o iguales asignados a la izquierda, 
	//y puntajes mayores para la derecha
	private void addChallenger(Player n, Player r) {
		if(n.getScore() <= r.getScore()) {
			if(r.getLeft() != null) {
				addChallenger(n, r.getLeft());
			} else {
				r.setLeft(n);
				n.setUp(r);
			}
		} else {
			if(r.getRight() != null) {
				addChallenger(n, r.getRight());
			} else {
				r.setRight(n);
				n.setUp(r);
			}
		}
	}
	
	public Player search(long score) {
		if(root == null) {
			return null;
		}else {
			return search(root, score);
		}
	}
	
	private Player search(Player current, long score) {
		if(current == null) {
			return current;
		}else if(current.getScore() == score) {
			return current;
		}else if(score > current.getScore()) {
			return search(current.getRight(), score);
		}else {
			return search(current.getLeft(), score);
		}
	}
	
	public void remove(long score) {
		Player pRem = search(score);
		removePlayer(pRem);
	}
	
	private void removePlayer(Player rem) {
		if(rem != null) {
			if(rem.getLeft() == null && rem.getRight() == null) { // CASO 1 el nodo es una hoja
				if(rem == root) {			// el arbol solo tiene un elemento
					root = null;
				}else if(rem == rem.getUp().getLeft()) {
					rem.getUp().setLeft(null);
				}else {
					rem.getUp().setRight(null);
				}
			}else if(rem.getLeft() == null || rem.getRight() == null) {	// CASO 2 el nodo tiene un solo hijo
				Player child;
				if(rem.getLeft()!=null) {	//tiene un hijo izquierdo
					child = rem.getLeft();
				}else {						//tiene un hijo derecho
					child = rem.getRight();
				}
				child.setUp(rem.getUp());
				if(rem == root) {
					root = child;
				}else if(rem == rem.getUp().getLeft()) {		//el nodo a eliminar es un hijo izq
					rem.getUp().setLeft(child);
				}else {											//el nodo a eliminar es un hijo der
					rem.getUp().setRight(child);
				}
			}else {							// CASO 3 el nodo tiene dos hijos
				Player succesor = min(rem.getRight());
				rem.setName(succesor.getName());			//le pasamos los datos del succesor al nodo
				rem.setScore(succesor.getScore());			//que queremos eliminar
				removePlayer(succesor);						//ahora borramos el duplicado
			}
		}
	}
	
	public Player minimun() {
		if(root == null) {
			return root;
		} else {
			return min(root);
		}
	}
	
	private Player min(Player current) {
		if(current.getLeft()==null) {
			return current;
		}else {
			return min(current.getLeft());
		}
	}
	
	public Player maximun() {
		if(root == null) {
			return root;
		} else {
			return max(root);
		}
	}
	
	private Player max(Player current) {
		if(current.getRight()==null) {
			return current;
		}else {
			return max(current.getRight());
		}
	}

}
