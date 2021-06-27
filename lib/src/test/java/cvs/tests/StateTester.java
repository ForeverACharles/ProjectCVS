package cvs.tests;

import cvs.state.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTester 
{
	@Test
	void testStateJsonParsing()
	{
		GameState testState = new GameState("MainMenu", null);
		assertTrue(testState.testJsonParser(), "the 'testJsonParser' method worked");
	}
}
