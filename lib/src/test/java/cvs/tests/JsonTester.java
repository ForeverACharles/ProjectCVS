package cvs.tests;

import cvs.app.*;
import cvs.state.*;

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
			JsonNode testJsonNode = JsonHandler.parseStringToJNode(JsonSource);
			
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
	
	@Test
	void readJsonContent() {
		String fullPath = "src/main/resources/states/MainMenuState.json";
		try {
			String contents = JsonHandler.getJsonContent(fullPath);
			System.out.println(contents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failed to load json");
		}
	}
}
