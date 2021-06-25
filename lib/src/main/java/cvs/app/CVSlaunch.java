package cvs.app;

import cvs.states.GameState;
import javafx.application.*;

public class CVSlaunch {

	public static void main(String[] args)
	{
		CVSdriver.printInfo("Starting Crossing Void Simulator...\n");
				
		CVSdriver.loadArgs(args);
		CVSdriver.printDebug("Loading arguments...\n");
		CVSdriver.printDebug("Loading stored user data...\n");
		CVSdriver.printDebug("Loading MainMenu state information...");		
		
		//bring up the mode select screen for GUI
		GameState mainMenuState = new GameState("MainMenu", null);
		
		CVSdriver.currentState = CVSdriver.selectMode(mainMenuState);
	
		CVSdriver.printInfo("\nEntering " + CVSdriver.currentState.getName() + "...\n");
		Application.launch(CVSdriver.class);
	}
}
