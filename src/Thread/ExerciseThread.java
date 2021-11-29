package Thread;

import model.Exercise;
import model.MathChallenge;

public class ExerciseThread extends Thread{
	
	private Exercise exercise;
	private MathChallenge mathChallenge;
	
	public ExerciseThread(Exercise ex, MathChallenge mt) {
		mathChallenge = mt;
		exercise = ex;
	}

	public void run() {
		exercise.generateExercise();
		mathChallenge.setExercise(exercise);
	}
	
}
