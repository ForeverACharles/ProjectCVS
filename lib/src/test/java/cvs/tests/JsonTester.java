package cvs.tests;

import cvs.app.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class JsonTester {
	
	@Test
	void testJsonStringParse()
	{
		try
		{
			String JsonSource = "{\"name\": \"charles\"}";
			JsonNode testJsonNode = JsonHandler.parseStringToNode(JsonSource);
			
			String fieldValue = testJsonNode.get("name").asText();
			System.out.println(fieldValue);
			
			assertEquals(fieldValue, "charles");
		}
		catch(IOException e)
		{
			System.out.println("Failed create JsonNode from string source");
			e.printStackTrace();
		}
	}
}
