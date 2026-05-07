package com.api.utilities;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import static com.api.Constants.Role.*;

import com.api.Constants.Role;
import com.api.pojo.UserCredentials;

import io.restassured.http.ContentType;

public class AuthTokenProvider {
	
	private AuthTokenProvider() {
		
	}

	public static String getToken(Role role) throws IOException {
	
		UserCredentials userCredentials = null;
		
		if(role == FD) {
			userCredentials = new UserCredentials("iamfd", "password");
		}
		else if(role == SUP) {
			userCredentials = new UserCredentials("iamsup", "password");
		}
		else if(role == ENG) {
			userCredentials = new UserCredentials("iameng", "password");
		}
		else if(role == QC) {
			userCredentials = new UserCredentials("iamqc", "password");
		}
		
	String token =	given().baseUri(ConfigManager.getProperty("BASE_URI")).and()
		.contentType(ContentType.JSON).and().
		body(userCredentials).when().post("login").then().log()
		.ifValidationFails().statusCode(200).extract().jsonPath().getString("data.token");
return token;
	}

}
