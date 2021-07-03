package cvs.app;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class JsonHandler {

	private static ObjectMapper OM = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper()
	{
		ObjectMapper defaultOM = new ObjectMapper();
		defaultOM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return defaultOM;
	}
	
	public static JsonNode parseStringToNode(String JsonSource) throws JsonMappingException, JsonProcessingException
	{
		return OM.readTree(JsonSource);
	}
	
	public static <T> T getClassFromJNode(JsonNode JNode, Class<T> requestedClass) throws JsonProcessingException
	{
		return OM.treeToValue(JNode, requestedClass);
	}
	
	public static JsonNode getJNodeFromClass(Object object)
	{
		return OM.valueToTree(object);
	}
	
	public static String getStringFromJNode(JsonNode JNode) throws JsonProcessingException
	{
		ObjectWriter OW = OM.writer();
		
		return OW.writeValueAsString(JNode);
	}
	
	public static String getStringTreeFromJNode(JsonNode JNode) throws JsonProcessingException 
	{
		ObjectWriter OW = OM.writer();
		OW = OW.with(SerializationFeature.INDENT_OUTPUT);
		
		return OW.writeValueAsString(JNode);
	}
	
	public static void printStringTree(String stringTree)
	{
		System.out.println(stringTree);
	}
	
	public static void writeObjectToFile(String filePath, Object object) throws JsonGenerationException, JsonMappingException, IOException
	{
		OM.writeValue(new File(filePath), object);
	}
	
	
	public static <T> String getObjectFilePath(String directory, Class<T> requestedClass)
	{
		return null;
	}
	public static String parseJsonFile(File filePath)
	{
		return null;
	}
	
}
