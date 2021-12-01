package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is Main Class.
 * @version 1
 * @author Juan Felipe Castillo Gomez, https://github.com/JuanFCast
 * @author Juan Camilo Ramirez Tabares, https://github.com/JCamiloRamirezTabares
 * @author Jesus David Rodriguez Burbano, https://github.com/JesusD03
 */

public class Main extends Application{
	
	private MathChallengeGUI controller;
	
	public static void main(String [] team) {
		launch(team);
	}
	
	@Override
	public void start(Stage primaryStage) {
        controller = new MathChallengeGUI();
        controller.setMainStage(primaryStage);
        try {
			controller.LogInMenu();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error");
		}
	}
}
