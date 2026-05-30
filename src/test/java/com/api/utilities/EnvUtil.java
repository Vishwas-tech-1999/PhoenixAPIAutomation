package com.api.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtil {
	
	private static Dotenv dotenv;
	
	static {
		dotenv =Dotenv.load();
		
	}
	
	
	private EnvUtil() {
		
	}
	
	public static String getValue(String VarName) {
		return dotenv.get(VarName);
	}

}
