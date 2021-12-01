package model;

/*
 * Añadir (Para añadir cada jugador al arbol binario)
 * Eliminar (Para borrar determinado jugador)
 * Buscar (Para buscar un jugador especifico)
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
	
	
	//Para este caso manejaremos puntajes menores o iguales asignados a la izquierda, y puntajes mayores para la derecha
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

}
