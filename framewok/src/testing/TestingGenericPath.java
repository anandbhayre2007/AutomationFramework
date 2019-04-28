package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestingGenericPath {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\.\\.\\objectrepository\\OR.properties");

		Properties p= new Properties();
		p.load(file);
		
	System.out.println(p.getProperty("continue"));
	}

}
