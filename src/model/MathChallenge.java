package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathChallenge {

	private Exercise exercise;
	private Player challenger;
	private Timer timer;
	private ScoreBoard scoreboard;
	private Player[] top5 = new Player[6];
	
	public MathChallenge() {
		scoreboard = new ScoreBoard();
	}
	
	public void startChallenge(String name) {
		challenger = new Player(name);
	}
	
	public void addPlayer() {
		scoreboard.addChallenger(challenger);
	}
	
	public void exportPlayers() throws IOException {
		scoreboard.setPositions();
		scoreboard.saveData();
	}
	
	public List<Player> top5Players() {
		ArrayList<Player> sublist = new ArrayList<Player>(Arrays.asList(top5));
		return sublist;
	}
	
	public void addInArray() {
		List<Player> top = topPlayers();
		
		try {
			top5[0] = top.get(0);
			top5[1] = top.get(1);
			top5[2] = top.get(2);
			top5[3] = top.get(3);
			top5[4] = top.get(4);
			top5[5] = challenger;
		} catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	private List<Player> topPlayers() {
		List<Player> topPlayer = scoreboard.top5();

		return topPlayer;
	}
	
	public void deleteChallenger(){
		scoreboard.removePlayer(challenger);
	}
	
	public String searchChallenger(String name) {
		Player p = scoreboard.search(name);
		
		if(p != null) {
			return p.toString();
		} else {
			return "Player not found";
		}
		
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
	
	public void setTimer(Timer t) {
		timer = t;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public boolean timeIsOver() {
		return timer.timeIsOver();
	}

	public Player[] getTop5() {
		return top5;
	}
	
}
