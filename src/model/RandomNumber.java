package model;

public class RandomNumber {
	
	private int min;
	private int max;
	
	public RandomNumber(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int getRandomNumber() {
		return (int) Math.floor(Math.random()*(max - min + 1) + min);
	}

}
