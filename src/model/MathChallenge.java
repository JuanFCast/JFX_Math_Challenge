package model;


public class MathChallenge {

	private Exercise exercise;
	private Player challenger;
	
	public MathChallenge(String name) {
		challenger = new Player(name);
	}
	
	public void createNewExercise() {
		exercise = new Exercise();
	}
	
	public String getExercise() {
		return exercise.getExercise();
	}
	
}
