package cvs.app;

import com.fasterxml.jackson.databind.*;
import java.io.*;

public class JsonHandler {

	private static ObjectMapper OM = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper()
	{
		ObjectMapper defaultOM = new ObjectMapper();
		
		return defaultOM;
	}
	
	
	public static JsonNode getNode(String JsonSource) throws IOException
	{
		return OM.readTree(JsonSource);
	}
	
	
}
