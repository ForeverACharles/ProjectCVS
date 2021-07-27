package cvs.tests;

import cvs.app.*;
import cvs.state.*;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTester 
{
	@Test
	void testStateJsonWriting()
	{	
		String directory = "src\\main\\resources\\states\\";
		
		//assertEquals(testState, methodTest);
		List<GameState> nextStates = new ArrayList<GameState>();
		GameState testState = new GameState("TestState", "TS", "Testing, testing... 1,2 ", null, nextStates);
		
		//System.out.println(BaseObject.getJsonTree(testState));
		
		GameState next1 = new GameState("next1", "n1", "1", testState, null);
		GameState next2 = new GameState("next2", "n2", "2", testState, null);
		GameState next3 = new GameState("next3", "n3", "3", testState, null);
		GameState next4 = new GameState("next4", "n4", "4", testState, null);
		GameState next5 = new GameState("next5", "n5", "5", testState, null);
		
		nextStates.add(next1);
		nextStates.add(next2);
		nextStates.add(next3);
		nextStates.add(next4);
		nextStates.add(next5);
		
		testState.setNextStates(nextStates);
		
		System.out.println(BaseObject.getJsonTree(testState));
		
		BaseObject.writeObjectToJson(testState, directory, testState.getName(), null);
	}
	
}