package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
	
	private String PLAYERS_SCORE_FILE = "data/PlayersScoreFile.psf";
	private Player root;
	private int position;
	private List<Player> top5 = new ArrayList<Player>();
	private Player orderByName;
	
	public ScoreBoard(){
		position = 1;
		try {
			loadData();//Importar
		} catch (ClassNotFoundException | IOException e) {}
		saveInOtherTree();
	}
	
	public void setPositions() {
		if(root==null) {
			
		}else {
			positions(root);
		}
	}
	
	private void positions(Player p) {
		if(p!=null) {
			positions(p.getRight());
			p.setPosition(position);
			position++;
			positions(p.getLeft());
		}
	}

	public void saveData() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PLAYERS_SCORE_FILE));
		oos.writeObject(root);
		oos.close();
	}
	
	private boolean loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File players = new File(PLAYERS_SCORE_FILE);
		boolean isLoaded = false;
		if(players.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(players));
			root = (Player) ois.readObject();
			ois.close();
			isLoaded = true;
		}
		return isLoaded;
	}
	
	private void saveInOtherTree() {
		if(root != null) {
			cloneInOthertree(root);
		} else {
			orderByName = null;
		}
	}
	

	private void cloneInOthertree(Player p) {
		
		if(p.getLeft() != null) {
			cloneInOthertree(p.getLeft());
		}
		
		addByName(p, orderByName);
		
		if(p.getRight() != null) {
			cloneInOthertree(p.getRight());
		}
	}
	
	private boolean addByName(Player p, Player r) {
		boolean sentinel = false;
		Player current = r;

		while(sentinel != true) {
			if(current == null) {
				current = p;
				sentinel = true;
			} else {
				if(p.getName().compareTo(current.getName()) < 0) {
					if(current.getLeft() == null) {
						current.setLeft(p);
						p.setUp(current);
						sentinel = true;
					} else {
						current = current.getLeft();
					}
				} else {
					if(current.getRight() == null) {
						current.setRight(p);
						p.setUp(current);
						sentinel = true;
					} else {
						current = current.getRight();
					}
				}
			}
		}
		
		return true;
	}
	
	//No me esta encontrando el player
	public void addChallenger(Player n) {
		if(root == null) {
			root = n;
		} else {
			if(search(n.getName()) != null) {
				Player oldSave = search(n.getName());
				if(oldSave.getScore() < n.getScore()) {
					removePlayer(oldSave);
					addChallenger(n, root);
				} else {
					
				}
			} else {
				addChallenger(n, root);
			}
		}
		
		orderByName = null;
		saveInOtherTree();
	}
	
	//Para este caso manejaremos puntajes menores o iguales asignados a la izquierda, 
	//y puntajes mayores para la derecha
	private boolean addChallenger(Player n, Player r) {
		if(n.getScore() <= r.getScore()) {
			if(r.getLeft() != null) {
				return addChallenger(n, r.getLeft());
			}else {
				r.setLeft(n);
				n.setUp(r);
				return true;
			}
		}else {
			if(r.getRight() != null) {
				return addChallenger(n, r.getRight());
			}else {
				r.setRight(n);
				n.setUp(r);
				return true;
			}
		}
	}
	
	public Player search(String name) {
		if(orderByName == null) {
			return null;
		}else {
			return search(orderByName, name);
		}
	}
	
	private Player search(Player current, String name) {
		if(current == null) {
			return current;
		}else if(current.getName().compareTo(name) == 0) {
			return current;
		}else if(current.getName().compareTo(name) > 0) {
			return search(current.getRight(), name);
		}else {
			return search(current.getLeft(), name);
		}
	}
	
	
	
	public void removePlayer(Player rem) {
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
	
	public List<Player> top5(){
		top5(root);
		return top5;
	}
	
	private void top5(Player current) {
		if(current!=null ) {
			top5(current.getRight());
			if(current.getPosition()<6) {
				top5.add(current);
			}
			top5(current.getLeft());
		}
	}
	
	public Player minimun() {
		if(root == null) {
			return root;
		}else {
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
		}else {
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
