package org.openjfx;

import cvs.app.CVSdriver;
import cvs.state.GameState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	public static void main(String[] args)
	{
		CVSdriver.printInfo("Starting Crossing Void Simulator...\n");
				
		CVSdriver.loadArgs(args);
		CVSdriver.printDebug("Loading arguments...\n");
		CVSdriver.printDebug("Loading stored user data...\n");
		CVSdriver.printDebug("Loading MainMenu state information...");		
		
		//bring up the mode select screen for GUI
		//GameState mainMenuState = new GameState("MainMenu", null);
		GameState MainMenuState = GameState.getStateFromStorage("MainMenu");
		
		CVSdriver.currentState = CVSdriver.selectMode(MainMenuState);
	
		CVSdriver.printInfo("\nEntering " + CVSdriver.currentState.getName() + "...\n");
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		System.exit(0);
	}
}
