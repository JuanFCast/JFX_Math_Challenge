package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import Thread.ExerciseThread;
import Thread.TimerThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Exercise;
import model.MathChallenge;
import model.RandomNumber;
import model.Timer;

public class MathChallengeGUI {

	//Attributes
	private Stage mainStage;
	private MathChallenge mathChallenge;
	
	@FXML
    private TextField Name_txtField;
	@FXML
    private Label exercise_Label;
	@FXML
    private Label nameOperator_label;
	@FXML
	private Button answer1_button;
	@FXML
	private Button answer2_button;
	@FXML
	private Button answer3_button;
	@FXML
	private Button answer4_button;
	@FXML
    private Label score_label;
    @FXML
    private Label nameChallenger_label;
    @FXML
    private Label timer_label;
	@FXML
	private TableView<?> tableTop;
	@FXML
	private TableColumn<?, ?> colNickname;
	
	
	public MathChallengeGUI() {
		
	}

	
	@FXML
    public void startChallenge(ActionEvent event) throws IOException, InterruptedException {
    	String name = Name_txtField.getText();
    	
    	if(!name.equals("")) {
    		mathChallenge = new MathChallenge(name);
        	ChallengeMenu();
        	Timer timer = new Timer();
        	mathChallenge.setTimer(timer);
        	startTimer(timer);
        	updateChallengeMenu();
    	} else {
    		printWarning("The field can't be void");
    	}
    }
	
	@FXML
	public void Answer1_Pressed(ActionEvent event) throws InterruptedException {
		if (answer1_button.getText().equals(mathChallenge.getAnswer())) {
			mathChallenge.getChallenger().increaseScore();
		}else {
			mathChallenge.getChallenger().decreaseScore();
		}
		updateChallengeMenu();
		
	}

	@FXML
	public void Answer2_Pressed(ActionEvent event) throws InterruptedException {
		if (answer2_button.getText().equals(mathChallenge.getAnswer())) {
			mathChallenge.getChallenger().increaseScore();
		}else {
			mathChallenge.getChallenger().decreaseScore();
		}
		updateChallengeMenu();
	}

	@FXML
	public void Answer3_Pressed(ActionEvent event) throws InterruptedException {
		if (answer3_button.getText().equals(mathChallenge.getAnswer())) {
			mathChallenge.getChallenger().increaseScore();
		}else {
			mathChallenge.getChallenger().decreaseScore();
		}
		updateChallengeMenu();
	}

	@FXML
	public void Answer4_Pressed(ActionEvent event) throws InterruptedException {
		if (answer4_button.getText().equals(mathChallenge.getAnswer())) {
			mathChallenge.getChallenger().increaseScore();
		}else {
			mathChallenge.getChallenger().decreaseScore();
		}
		updateChallengeMenu();
	}
	
	public void LogInMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login_pane.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.setTitle("Modulo de Inicio");
        mainStage.show();
	}
	
	private void ChallengeMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("challenge_pane.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.setTitle("Math Challenge");
        mainStage.show();
	}
	
	private void updateChallengeMenu() throws InterruptedException {
		ExerciseThread ext = new ExerciseThread(new Exercise(), mathChallenge);
		ext.start();
		ext.join();
		nameChallenger_label.setText(mathChallenge.getChallenger().getName());
		score_label.setText(""+mathChallenge.getChallenger().getScore());
		nameOperator_label.setText(mathChallenge.getNameOperator());
		exercise_Label.setText(mathChallenge.getExercise());
		randomAnswers();
	}
	
	
	private void randomAnswers() {
		
		RandomNumber num = new RandomNumber(1,4);
		int r = num.getRandomNumber();

		switch (r) {
		case 1:
			answer1_button.setText(mathChallenge.getAnswer());
			answer2_button.setText(mathChallenge.getFakeAnswer()[0]);
			answer3_button.setText(mathChallenge.getFakeAnswer()[1]);
			answer4_button.setText(mathChallenge.getFakeAnswer()[2]);
			break;
		
		case 2:
			answer1_button.setText(mathChallenge.getFakeAnswer()[0]);
			answer2_button.setText(mathChallenge.getAnswer());
			answer3_button.setText(mathChallenge.getFakeAnswer()[1]);
			answer4_button.setText(mathChallenge.getFakeAnswer()[2]);
			break;
		
		case 3:
			answer1_button.setText(mathChallenge.getFakeAnswer()[0]);
			answer2_button.setText(mathChallenge.getFakeAnswer()[1]);
			answer3_button.setText(mathChallenge.getAnswer());
			answer4_button.setText(mathChallenge.getFakeAnswer()[2]);
			break;
			
		case 4:
			answer1_button.setText(mathChallenge.getFakeAnswer()[0]);
			answer2_button.setText(mathChallenge.getFakeAnswer()[1]);
			answer3_button.setText(mathChallenge.getFakeAnswer()[2]);
			answer4_button.setText(mathChallenge.getAnswer());
			break;

		default:
			break;
		}

	}
	
	public void startTimer(Timer t) throws InterruptedException {
		Thread.sleep(1000);
		TimerThread timerThread = new TimerThread(t, mathChallenge);
		timer_label.setText(mathChallenge.getTime());
		
		if(!mathChallenge.timeIsOver()) {
			timerThread.start();
			timerThread.join();
			startTimer(t);
		}

		
//		while(mathChallenge.timeIsOver() == false) {
//			timer_label.setText(mathChallenge.getTime());
//			Thread.sleep(1000);
//			mathChallenge.start();
//		}
	}
	
	
	
	
	//Getters & Setters
	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	//Reports
	public void printWarning(String message) {
    	JOptionPane.showMessageDialog(null, message);
    }

}
