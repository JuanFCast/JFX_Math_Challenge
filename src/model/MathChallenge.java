package model;

public class MathChallenge {

	private Exercise exercise;
	private Player challenger;
	private Timer timer;
	
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
	
	public long getScore() {
		return challenger.getScore();
	}
	
	public void setTimer(Timer t) {
		timer = t;
	}
	
	public String getTime() {
		return timer.time();
	}
	
	public boolean timeIsOver() {
		return timer.timeIsOver();
	}
	
}
