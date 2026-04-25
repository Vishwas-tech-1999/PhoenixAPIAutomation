package com.api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static String path = "config/config.properties";
	private static String env;
	private static Properties properties = new Properties();

	private ConfigManager() {
		// restricting the object creation outside the class
	}

//static block - static block will be executed once when the class loaded in to the memory
	static {
		env = System.getProperty("env", "qa");
		env = env.toLowerCase().trim();
		switch (env) {
		case "dev" -> path = "config/config.dev.properties";

		case "qa" -> path = "config/config.qa.properties";

		case "uat" -> path = "config/config.uat.properties";

		default -> path = "config/config.properties";
		}
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (input == null) {
			throw new RuntimeException("Input file not found in the given path " + path);
		}

		try {

			properties.load(input);
		} catch (IOException e) {

		}

	}

	public static String getProperty(String key) throws IOException {
		// TODO Auto-generated method stub

		return properties.getProperty(key);

	}

}
