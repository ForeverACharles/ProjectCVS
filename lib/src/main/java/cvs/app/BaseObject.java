package cvs.app;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class BaseObject {

	public static <T> T getObjectFromStorage(Class <T> requestedClass, String directory, String objectName, String suffix)
	{
		try 
		{
			return JsonHandler.getObject(requestedClass, directory, objectName, suffix);
		}
		catch (IOException e)
		{
			CVSdriver.printDebug("Failed to locate the object");
			return null;
		}
	}
	
	public static <T> boolean writeObjectToJson(Object object, String directory, String objectName, String suffix) 
	{
		String filePath = directory + objectName;
		if(suffix != null)
		{
			filePath = filePath + suffix;
		}
		filePath = filePath + ".json";
		
		try 
		{
			JsonHandler.writeObjectToJsonTree(filePath, object);
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	public static String getJsonTree(Object object)
	{
		try 
		{
			JsonNode JNode = JsonHandler.getJNodeFromObject(object);
			return JsonHandler.getContentTreeFromJNode(JNode);
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
