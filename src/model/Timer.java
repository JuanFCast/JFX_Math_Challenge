package model;

public class Timer {

	private int minutes = 0;
	private int seconds = 10;
	
	
	public Timer() {
		
	}
	
	public void startTimer() {
		
		if(minutes > 0) {
			if(seconds > 0) {
				seconds--;
			} else {
				seconds = 60;
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
