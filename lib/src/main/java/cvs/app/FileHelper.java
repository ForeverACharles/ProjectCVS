package cvs.app;

import java.io.*;

public class FileHelper {

	
	public static String getClassName(Object object) 
	{
        String className = object.getClass().getSimpleName(); 
        return className;
    }
	
	public static File getFile(String dir, Object object, String suffix)
	{
		String objectPath = dir + getClassName(object) + suffix;
		File objectFile = new File(objectPath);
		return objectFile;
	}
	
	
}
