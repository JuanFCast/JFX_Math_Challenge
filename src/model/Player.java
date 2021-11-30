package model;

public class Player {
	
	private int position;
	private String name;
	private long score;
	
	//FOR BST
	private Player up;
	private Player left;
	private Player right;
	
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public void increaseScore() {
		score += 10; 
	}
	
	public void decreaseScore() {
		score -= 10;
	}
	
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	
	public long getScore() {
		return score;
	}
	
	public Player getUp() {
		return up;
	}

	public void setUp(Player up) {
		this.up = up;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	//ToString
	public String toString() {
		return position + ". " + name + "   " + score;
	}

}
