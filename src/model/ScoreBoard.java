package model;

//Aca se contruiara la tabla de posiciones
public class ScoreBoard {
	
	private Player root;
	
	public ScoreBoard() {
		
	}
	
	public void addChallenger(Player n) {
		if(root == null) {
			root = n;
		}else {
			addChallenger(n, root);
		}
	}
	//Para este caso manejaremos puntajes menores o iguales asignados a la izquierda, y puntajes mayores
	//para la derecha
	public void addChallenger(Player n, Player r) {
		if(n.getScore() <= r.getScore()) {
			if(r.getLeft() != null) {
				addChallenger(n, r.getLeft());
			} else {
				r.setLeft(n);
			}
		} else {
			if(r.getRight() != null) {
				addChallenger(n, r.getRight());
			} else {
				r.setRight(n);
			}
		}
	}

}
