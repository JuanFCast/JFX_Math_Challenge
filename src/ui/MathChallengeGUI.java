package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import Thread.ExerciseThread;
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

public class MathChallengeGUI {

	//Attributes
	private Stage mainStage;
	private MathChallenge mathChallenge;
	private ExerciseThread ext;
	
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
        	updateChallengeMenu();
    	} else {
    		printWarning("The field can't be void");
    	}
    }
	
	@FXML
	public void Answer1_Pressed(ActionEvent event) throws InterruptedException {
		updateChallengeMenu();
	}

	@FXML
	public void Answer2_Pressed(ActionEvent event) {

	}

	@FXML
	public void Answer3_Pressed(ActionEvent event) {

	}

	@FXML
	public void Answer4_Pressed(ActionEvent event) {

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
		ext = new ExerciseThread(new Exercise(), mathChallenge);
		ext.start();
		ext.join();
		nameOperator_label.setText(mathChallenge.getNameOperator());
		exercise_Label.setText(mathChallenge.getExercise());
		answer1_button.setText(mathChallenge.getAnswer());
		
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
