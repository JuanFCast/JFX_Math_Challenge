package Thread;

import model.MathChallenge;
import model.Timer;

public class TimerThread extends Thread {

	private Timer timer;
	private MathChallenge mathChallenge;
	
	public TimerThread(Timer t, MathChallenge mt) {
		timer = t;
		mathChallenge = mt;
	}
	
	public void run() {
		try {
			sleep(20);
			timer.startTimer();
			mathChallenge.setTimer(timer);
		} catch (InterruptedException e) {
			
		}
		
	}
		
}
