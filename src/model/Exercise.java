package model;


//Aca se construira el ejercicio: Solo el ejercicio
public class Exercise {

	private int numb1;
	private int numb2;
	private String operator;
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
		
		RandomNumber genNumber = new RandomNumber(0, 99);
		RandomNumber genOperator = new RandomNumber(1, 4);
		
		int aux1 = genNumber.getRandomNumber();
		int aux2 = genNumber.getRandomNumber();
		int o = genOperator.getRandomNumber();
		
		switch(o) {
		case 1:
			numb1 = aux1;
			numb2 = aux2;
			operator = "+";
			
			answer = numb1 + numb2;
			fakeAnswers();
			break;
		case 2:
			numb1 = aux1;
			numb2 = aux2;
			operator = "-";
			
			answer = numb1 - numb2;
			fakeAnswers();
			break;
		case 3:
			numb1 = aux1;
			numb2 = aux2;
			operator = "x";
			
			answer = numb1 * numb2;
			fakeAnswers();
			break;
		case 4:
			if(aux1%aux2 == 0) {
				numb1 = aux1;
				numb2 = aux2;
				operator = "/";
				
				answer = numb1 / numb2;
				fakeAnswers();
			} else {
				generateExercise();
			}
			break;
		}
	}
	
	private void fakeAnswers() {
		fakeAnswers(1, fakeAnswer1);
	}
	
	private void fakeAnswers(int o, long f) {
		
		RandomNumber adder = new RandomNumber(1, 10);
		RandomNumber operator = new RandomNumber(1, 2);
		
		int op = operator.getRandomNumber();
		
		switch(op) {
		case 1:
			f = answer + adder.getRandomNumber();
			break;
		case 2:
			f = answer - adder.getRandomNumber();
			break;
		}
		
		while(o <= 3) {
			
		}
		
		if(o == 1) {
			fakeAnswers(2, fakeAnswer2);
		} else if(o == 2) {
			if(fakeAnswer1 == fakeAnswer2) {
				fakeAnswers(2, fakeAnswer2);
			} else {
				fakeAnswers(3, fakeAnswer3);
			}
		} else {
			if(fakeAnswer3 == fakeAnswer1 || fakeAnswer3 == fakeAnswer2) {
				fakeAnswers(3, fakeAnswer3);
			}
		}
		
	}
	
	public String getExercise() {
		return numb1 + operator + numb2;
	}
	
	public String getAnswer() {
		return "" + answer;
	}
	
}
