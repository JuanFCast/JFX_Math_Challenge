package model;


//Aca se construira el ejercicio: Solo el ejercicio
public class Exercise {

	private int numb1;
	private int numb2;
	private String operator;
	private String nameOperator;
	private long answer;
	private long fakeAnswer1;
	private long fakeAnswer2;
	private long fakeAnswer3;
	
	private RandomNumber genNumber;
	private RandomNumber genOperator;
	
	public Exercise() {
		genNumber = new RandomNumber(0, 99);
		genOperator = new RandomNumber(1, 6);
	}
	
	
	/*
	 * 1 = " SUMA "
	 * 2 = " RESTA "
	 * 3 = " MULTIPLICACION "
	 * 4 = " DIVISION "
	 * */
	public void generateExercise() {
		
		int aux1 = genNumber.getRandomNumber();
		int aux2 = genNumber.getRandomNumber();
		int o = genOperator.getRandomNumber();
		
		switch(o) {
		case 1:
			numb1 = aux1;
			numb2 = aux2;
			operator = "+";
			nameOperator = "SUMA";
			
			answer = numb1 + numb2;
			fakeAnswers();
			break;
		case 2:
			numb1 = aux1;
			numb2 = aux2;
			operator = "-";
			nameOperator = "RESTA";
			
			answer = numb1 - numb2;
			fakeAnswers();
			break;
		case 3:
			numb1 = aux1;
			numb2 = aux2;
			operator = "x";
			nameOperator = "MULTIPLICACION";
			
			answer = numb1 * numb2;
			fakeAnswers();
			break;
		default:
			if(aux2 != 0) {
				if(aux1%aux2 == 0) {
					numb1 = aux1;
					numb2 = aux2;
					operator = "/";
					nameOperator = "DIVISION";
					
					answer = numb1 / numb2;
					fakeAnswers();
				} else {
					generateExercise();
				}
			} else {
				generateExercise();
			}
			break;
		}
	}
	
	private void fakeAnswers() {
		int o = 1;
		
		RandomNumber adder = new RandomNumber(1, 10);
		RandomNumber operator = new RandomNumber(1, 2);
		
		int op = operator.getRandomNumber();
		
		while(o <= 3) {
			if(o == 1) {
				switch(op) {
				case 1:
					fakeAnswer1 = answer + adder.getRandomNumber();
					break;
				case 2:
					fakeAnswer1 = answer - adder.getRandomNumber();
					break;
				}
				o++;
			} else if(o == 2) {
				switch(op) {
				case 1:
					fakeAnswer2 = answer + adder.getRandomNumber();
					break;
				case 2:
					fakeAnswer2 = answer - adder.getRandomNumber();
					break;
				}
				
				if(fakeAnswer1 == fakeAnswer2) {
					o = 2;
				} else {
					o++;
				}
			} else {
				switch(op) {
				case 1:
					fakeAnswer3 = answer + adder.getRandomNumber();
					break;
				case 2:
					fakeAnswer3 = answer - adder.getRandomNumber();
					break;
				}
				
				if(fakeAnswer3 == fakeAnswer1 || fakeAnswer3 == fakeAnswer2) {
					o = 3;
				} else {
					o++;
				}
			}
		}
	}
	
	public String getExercise() {
		return numb1 + operator + numb2;
	}
	
	public String getAnswer() {
		return "" + answer;
	}
	
	public String[] getFakeAnswers() {
		String [] fakeAnswers = { "" + fakeAnswer1, "" + fakeAnswer2, "" + fakeAnswer3};
		return fakeAnswers;
	}
	
	public String getNameOperator() {
		return nameOperator;
	}
	
}
