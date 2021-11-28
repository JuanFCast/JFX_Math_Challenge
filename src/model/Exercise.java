package model;


//Aca se construira el ejercicio: Solo el ejercicio
public class Exercise {

	private int numb1;
	private int numb2;
	private long answer;
	private long fakeAnswer1;
	private long fakeAnswer2;
	private long fakeAnswer3;
	
	public Exercise() {
		generateExercise();
	}
	
	
	/*
	 * 1 = " SUMA "
	 * 2 = " RESTA "
	 * 3 = " MULTIPLICACION "
	 * 4 = " DIVISION "
	 * */
	private void generateExercise() {
		
		RandomNumber generator = new RandomNumber(0, 99);
		RandomNumber operator = new RandomNumber(1, 4);
		
		int aux1 = generator.getRandomNumber();
		int aux2 = generator.getRandomNumber();
		int o = operator.getRandomNumber();
		
		switch(o) {
		case 1:
			numb1 = aux1;
			numb2 = aux2;
			
			answer = numb1 + numb2;
			fakeAnswers();
			break;
		case 2:
			numb1 = aux1;
			numb2 = aux2;
			
			answer = numb1 - numb2;
			fakeAnswers();
			break;
		case 3:
			numb1 = aux1;
			numb2 = aux2;
			
			answer = numb1 * numb2;
			fakeAnswers();
			break;
		case 4:
			
			break;
		}
	}
	
	private void fakeAnswers() {
		fakeAnswers(1, fakeAnswer1);
	}
	
	private void fakeAnswers(int o, long f) {
		
		RandomNumber adder = new RandomNumber(1, 10);
		RandomNumber operator = new RandomNumber(1,2);
		
		int op = operator.getRandomNumber();
		
		switch(op) {
		case 1:
			f = answer + adder.getRandomNumber();
			break;
		case 2:
			f = answer - adder.getRandomNumber();
			break;
		}
		
		switch(o) {
		case 1:
			fakeAnswers(2, fakeAnswer2);
			break;
		case 2:
			fakeAnswers(3, fakeAnswer3);
			break;
		default:
			
			break;
		}
		
	}
}
