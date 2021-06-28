package cvs.tests;

import cvs.app.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class JsonTester {
	
	@Test
	void testJsonHandler()
	{
		try
		{
			JsonNode test = JsonHandler.getNode("name: charles");
			JsonNode control = new JsonNode();
		}
		catch(IOException e)
		{
			
			
		}
	}
}
