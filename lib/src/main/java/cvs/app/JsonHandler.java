package cvs.app;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonHandler {

	private static ObjectMapper OM = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper()
	{
		ObjectMapper defaultOM = new ObjectMapper();
		//defaultOM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultOM;
	}
	
	public static JsonNode parseStringToJNode(String JsonSource) throws JsonMappingException, JsonProcessingException
	{
		return OM.readTree(JsonSource);
	}
	
	public static <T> T getObjectFromJNode(JsonNode JNode, Class<T> requestedClass) throws JsonProcessingException
	{
		return OM.treeToValue(JNode, requestedClass);
	}
	
	public static JsonNode getJNodeFromObject(Object object)
	{
		return OM.valueToTree(object);
	}
	
	public static String getContentFromJNode(JsonNode JNode) throws JsonProcessingException
	{
		ObjectWriter OW = OM.writer();
		
		return OW.writeValueAsString(JNode);
	}
	
	public static String getContentTreeFromJNode(JsonNode JNode) throws JsonProcessingException 
	{
		ObjectWriter OW = OM.writer();
		OW = OW.with(SerializationFeature.INDENT_OUTPUT);
		//OW.with(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL);
		
		return OW.writeValueAsString(JNode);
	}
	
	public static void printContentTree(String JsonTree)
	{
		System.out.println(JsonTree);
	}
	
	public static <T> String getJsonPath(String directory, Class<T> requestedClass)
	{
		return FileHelper.getPathFromClass(directory, requestedClass) + ".json";
	}
	
	public static <T> String getJsonPath(String directory, Class<T> requestedClass, String suffix)
	{
		return FileHelper.getPathFromClass(directory, requestedClass) + suffix + ".json";
	}
	
	public static void writeObjectToJson(String filePath, Object object) throws JsonGenerationException, JsonMappingException, IOException
	{
		OM.writeValue(new File(filePath), object);
	}
	
	public static void writeObjectToJsonTree(String filePath, Object object) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectWriter OW = OM.writer();
		OW = OW.with(SerializationFeature.INDENT_OUTPUT);
		//OW.with(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL);
		
		OW.writeValue(new File(filePath), object);
	}
	
	public static String getJsonContent(String fullPath) throws IOException
	{
		Path filePath = Path.of(fullPath);
		
		String contents = Files.readString(filePath);
		return contents;
	}
	
	public static <T> T getObject(Class <T> requestedClass, String directory, String objectName, String suffix) throws IOException
	{
		String filePath = directory + objectName;
		if(suffix != null)
		{
			filePath = filePath + suffix;
		}
		filePath = filePath + ".json";
		
		String contents = getJsonContent(filePath);
		if(contents == null)
		{
			return null;
		}
		
		JsonNode contentNode = parseStringToJNode(contents);
		
		return getObjectFromJNode(contentNode, requestedClass);
	}
	
	public static <T> T getObject(Class <T> requestedClass, String directory, String suffix) throws IOException
	{
		String filePath = "";
		if(suffix != null)
		{
			filePath = getJsonPath(directory, requestedClass, suffix);
		}
		else
		{
			filePath = getJsonPath(directory, requestedClass);
		}
		
		String contents = getJsonContent(filePath);
		if(contents == null)
		{
			return null;
		}
		
		JsonNode contentNode = parseStringToJNode(contents);
		
		return getObjectFromJNode(contentNode, requestedClass);
	}
}
