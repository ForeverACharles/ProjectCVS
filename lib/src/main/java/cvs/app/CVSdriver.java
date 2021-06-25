package cvs.app;

import java.io.*;
import java.util.*;
import cvs.states.*;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class CVSdriver extends Application {

	public static boolean devMode = false;
	public static GameState currentState;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		
	}
	
	public static void printInfo(String statement)
	{
		System.out.println(statement);
	}
	
	public static void printDebug(String statement)
	{
		if(devMode == true)	{	System.out.println(statement);	}
	}
	
	public static void printHelp()
	{
		printInfo("----------------------------------\n");
		printInfo("Crossing Void Simulator Help Guide\n\n");
		printInfo("List of Parameters");
		printInfo("------------------\n");
		printInfo(" h\t View help guide for this simulator");
		printInfo(" d\t Enable developer mode to view runtime information and modify game data");
		printInfo("\n");
	}
	
	public static void loadArgs(String[] args)
	{	
		List<String> argumentList = Arrays.asList(args);
		
		if(argumentList.contains("h"))
		{
			printHelp();
			System.exit(0);
		}
		if(argumentList.contains("d"))
		{
			devMode = true;
			printDebug("Developer mode enabled!");
		}
	}
	
	public static GameState selectMode(GameState sourceState)
	{
		String selectionMesssage = "Crossing Void Modes";
		sourceState.displayStateTransitionTable(selectionMesssage);
		
		String inputMessage = "Type the Mode you want to enter";
		return sourceState.getStateTransitionInput(inputMessage);
	}

}
