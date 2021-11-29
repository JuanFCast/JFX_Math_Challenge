package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MathChallenge;

public class MathChallengeGUI {

	//Attributes
	private Stage mainStage;
	private MathChallenge mathChallenge;
	
	@FXML
    private TextField Name_txtField;
	@FXML
    private Label exercise_Label;
	
	
	public MathChallengeGUI() {
		
	}

	
	@FXML
    public void startChallenge(ActionEvent event) throws IOException {
    	String name = Name_txtField.getText();
    	
    	if(!name.equals("")) {
    		mathChallenge = new MathChallenge(name);
        	ChallengeMenu();
        	updateChallengeMenu();
    	} else {
    		printWarning("The field can't be void");
    	}
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
	
	private void updateChallengeMenu() {
		mathChallenge.createNewExercise();
		exercise_Label.setText(mathChallenge.getExercise());
		
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
