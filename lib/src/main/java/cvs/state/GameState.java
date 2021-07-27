package cvs.state;

import cvs.app.*;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "name"
		)
@JsonPropertyOrder({ "name", "code", "desc", "prevState", "nextStates"})
public class GameState extends BaseObject
{
	private static final String directory = "src\\main\\resources\\states\\";
	
	private String stateName;
	private String code;
	private String description;
	private GameState prevState;
	private List<GameState> nextStates = new ArrayList<GameState>();
	
	public GameState(String stateName, GameState prev)
	{
		loadStateInfoFromTxt(stateName, prev);
		printStateInfo();
	}
	
	public GameState(String stateName, String code, String description, GameState prevState, List<GameState> nextStates)
	{
		//loadStateInfoFromTxt(stateName, prev);
		
		//loadStateInfoFromJson(stateName, directory);
		
		this.stateName = stateName;
		this.code = code;
		this.description = description;
		this.prevState = prevState;
		setNextStates(nextStates);
		
		writeObjectToJson(this, directory, stateName, "State");
		
		//printStateInfo();
	}
	
	private void loadStateInfoFromTxt(String stateName, GameState prev)
	{
		File stateFile;
		String filePath = "src\\main\\resources\\states\\StateTransitions.txt";
		Scanner Scan;
		try 
		{
			stateFile = new File(filePath);
			if(stateFile.createNewFile())
			{
				CVSdriver.printDebug("Creating StateTransitions.txt");
			}
			Scan = new Scanner(stateFile);
		}
		catch(Exception e)
		{
			CVSdriver.printDebug("Error: Could not locate StateTransitions.txt");
			return;
		}
			
		String stateEntry = "";
		while(Scan.hasNextLine())
		{
			String currentLine = Scan.nextLine();
			String[] tokens = currentLine.split(" ", 0);
			String metadata = tokens[0];
			
			if(metadata.equals("state:") && tokens[1].equals(stateName))
			{
				this.stateName = stateName;	
				stateEntry = tokens[1];
			}
			if(metadata.equals("code:") && stateEntry.equals(stateName))
			{
				code = tokens[1];
			}
			if(metadata.equals("desc:") && stateEntry.equals(stateName))
			{
				description = "";
				for(int i = 1; i < tokens.length; i++)
				{
					description = description + tokens[i] + " ";
				}
				description = description.trim();
			}
			if(metadata.equals("prev:") && stateEntry.equals(stateName))
			{
				if(tokens.length > 1)
				{
					prevState = prev;
				}
			}
			if(metadata.equals("next:") && stateEntry.equals(stateName))
			{
				for(int i = 1; i < tokens.length; i++)
				{
					GameState nextState = new GameState(tokens[i], this);
					nextStates.add(nextState); 
				}
				break;	//finished creating state instance
			}
		}
		Scan.close();
	} 
	
	public static GameState getStateFromStorage(String stateName)
	{
		return getObjectFromStorage(GameState.class, directory, stateName, "State");
	}
	
	public String getName()	{	return stateName;	}
	
	public String getCode()	{	return code;	}
	
	public String getDesc()	{	return description;	}
	
	public GameState getPrevState()	{	return prevState;	}	
	
	public void setPrevState(GameState newState) 
	{	
		prevState = newState;
		//writeObjectToJson(this, directory, stateName, "State");
	}
	
	public List<GameState> getNextStates()	{	return nextStates;	}
	
	public void setNextStates(List<GameState> nextStates)
	{
		if(nextStates != null)
		{
			this.nextStates.addAll(nextStates);
		}
		//writeObjectToJson(this, directory, stateName, "State");
	}
	
	public void addNextState(GameState nextState)
	{
		nextStates.add(nextState);
		//writeObjectToJson(this, directory, stateName, "State");
	}
	
	public void printStateInfo()
	{
		CVSdriver.printDebug("\t" + stateName + ", " + code);
		CVSdriver.printDebug("\t" + description);
		
		String prev = "prev: "; 
		if(prevState != null)
		{
			prev = prev + prevState.getName();
		}
		CVSdriver.printDebug("\t" + prev);
		
		String next = "next: ";
		for(GameState nextState : nextStates)
		{
			next = next + nextState.getName() + " ";
		}	
		CVSdriver.printDebug("\t" + next + "\n");
	}
	
	public void displayStateTransitionTable(String selectionMessage)
	{
		CVSdriver.printInfo(" " + stateName + "\n");
		CVSdriver.printInfo(" " + description);
		if(selectionMessage != null)
		{
			CVSdriver.printInfo(" -----------------------------------\n");
			CVSdriver.printInfo(" " + selectionMessage + "\n\n");
		}
		
		for(GameState nextState : this.getNextStates())
		{
			String stateTableEntry;	
			stateTableEntry			= " " + String.format("%-2s", nextState.getCode()) + " -  ";
			stateTableEntry 		= stateTableEntry + String.format("%-18s", nextState.getName());
			stateTableEntry 		= stateTableEntry + nextState.getDesc();
			
			CVSdriver.printInfo(stateTableEntry);
			CVSdriver.printInfo("");
		}
		CVSdriver.printInfo(" -----------------------------------");
	}
	
	public GameState getState(String stateName)
	{
		for(GameState nextState : nextStates)
		{
			if(nextState.getName().equals(stateName) || nextState.getCode().equals(stateName))
			{
				return nextState;
			}
		}
		return null;
	}
	
	public GameState getStateTransitionInput(String inputMessage)
	{
		String inputState = "";
		GameState returnState;
		Scanner Scan = new Scanner(System.in);
		do
		{
			CVSdriver.printInfo(" " + inputMessage);
			CVSdriver.print(" ");
			inputState = Scan.nextLine();
			returnState = getState(inputState);
		} while(returnState == null);
		
		Scan.close();
		return returnState;
	}	
	
	public static void createState()
	{
		Scanner Scan = new Scanner(System.in);
		CVSdriver.printInfo("");
	}
	
}
