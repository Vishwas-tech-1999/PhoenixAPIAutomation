package com.api.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManagerOld {
private static Properties properties = new Properties();

private ConfigManagerOld() {
	// restricting the object creation outside the class
}

//static block - static block will be executed once when the class loaded in to the memory
static {
	File configfile =  new File(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config"+File.separator+"config.properties");
	
	FileReader filereader =  null;
	try {
		filereader = new FileReader(configfile);
		
			properties.load(filereader);
	}
		 catch (IOException e) {
			
		}
	
}
	

	public static  String getProperty(String key) throws IOException {
		// TODO Auto-generated method stub
		
		
		
	
		
		return properties.getProperty(key);

	}

}
