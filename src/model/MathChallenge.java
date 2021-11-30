package model;

public class MathChallenge {

	private Exercise exercise;
	private Player challenger;
	
	public MathChallenge(String name) {
		challenger = new Player(name);
	}
	
	public String getExercise() {
		return exercise.getExercise();
	}
	
	public String getAnswer() {
		return exercise.getAnswer();
	}
	
	public String[] getFakeAnswer() {
		return exercise.getFakeAnswers();
	}
	
	public void setExercise(Exercise ex) {
		exercise = ex;
	}
	
	public String getNameOperator() {
		return exercise.getNameOperator();
	}
	
	public Player getChallenger() {
		return challenger;
	}
	
}
