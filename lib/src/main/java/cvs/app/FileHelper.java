package cvs.app;

import java.io.*;

public class FileHelper {

	
	public static String getClassName(Object object) 
	{
        String className = "" + object.getClass().getSimpleName(); 
        return className;
    }
	
	public static <T> String getClassName(Class<T> requestedClass) 
	{
        String className = "" + requestedClass.getSimpleName();
        return className;
    }
	
	public static <T> String getPathFromClass(String directory, Class<T> requestedClass)
	{
		String fullPath = "" + directory + getClassName(requestedClass);
		return fullPath;
	}
	
	public static <T> String getPathFromClass(String directory, Class<T> requestedClass, String suffix)
	{
		String fullPath = "" + directory + getClassName(requestedClass) + suffix;
		return fullPath;
	}
	
	public static File getFile(String dir, Object object)
	{
		String objectPath = dir + getClassName(object);
		File objectFile = new File(objectPath);
		return objectFile;
	}
	
	public static File getFile(String dir, Object object, String suffix)
	{
		String objectPath = dir + getClassName(object) + suffix;
		File objectFile = new File(objectPath);
		return objectFile;
	}
	
	
}
