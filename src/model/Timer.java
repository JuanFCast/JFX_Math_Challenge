package model;

public class Timer {

	private int minutes = 1;
	private int seconds = 1;
	
	
	public Timer() {
		
	}
	
	public void startTimer() {
		
		if(minutes > 0) {
			if(seconds > 0) {
				seconds--;
			} else {
				seconds = 59;
				minutes--;
			}
		} else {
			if(seconds > 0) {
				seconds--;
			}
		}
	}
	
	public boolean timeIsOver() {
		return (minutes == 0 && seconds == 0)?true:false;
	}
	
	public long getTotalSeconds() {
		long s = seconds;
		
		if(minutes > 0) {
			s += (60*minutes);
		}
		
		return s;
	}
	
	public String time() {
		String time = "";
		
		if(minutes >= 10) {
			time = "" + minutes;
		} else {
			time = "0" + minutes;
		}
		
		time += ":";
		
		if(seconds >= 10) {
			time += "" + seconds;
		} else {
			time += "0" + seconds;
		}
		
		return time;
	}
	
	
}
