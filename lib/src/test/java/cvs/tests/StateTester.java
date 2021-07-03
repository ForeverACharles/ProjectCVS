package cvs.tests;

import cvs.state.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTester 
{
	@Test
	void testStateJsonLoading()
	{
		GameState testState = new GameState("MainMenu", null);
		
		GameState methodTest = GameState.loadStateInfoFromJson("MainMenu");
		
		//assertEquals(testState, methodTest);
	}
}