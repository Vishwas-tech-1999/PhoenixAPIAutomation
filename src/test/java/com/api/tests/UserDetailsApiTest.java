package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import java.io.IOException;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

import com.api.utilities.ConfigManagerOld;
import static com.api.Constants.Role.*;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;

public class UserDetailsApiTest {

	
	@Test
	public void userDetaulsApiTest() throws IOException {
		
		Header authHeader = new Header("Authorization", AuthTokenProvider.getToken(ENG));
 
		given().baseUri(ConfigManager.getProperty("BASE_URI"))
		.and()
		.contentType(JSON)
		.header(authHeader)
		.when()
		.get("userdetails")
		.then().log().all().
		and().
		body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\UserDetailsresponseSchema.json"));
	}
}
