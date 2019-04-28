package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import configFile.config_File;

public class ReadOR {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties or= new Properties();		
		FileInputStream file= new FileInputStream(config_File.or);		
		or.load(file);
		
		System.out.println(or.getProperty("username"));

	}

}
