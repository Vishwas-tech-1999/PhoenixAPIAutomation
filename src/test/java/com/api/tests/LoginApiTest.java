package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utilities.ConfigManager;

import static com.api.utilities.ConfigManagerOld.*;

import io.restassured.module.jsv.JsonSchemaValidator;


public class LoginApiTest {
	
	@Test
	public void loginApiTest() throws IOException {
		
		System.getProperty("----------------"+"env");
		
		UserCredentials user = new UserCredentials("iamfd", "password");
		
		given().baseUri(ConfigManager.getProperty("BASE_URI")).
		and().
		contentType(JSON)
		.and()
		.accept(ANY)
		.and()
		.body(user)
		.and()
		.log().uri()
		.and()
		.log().method()
		.log().headers()
		.log().body()
		.when()
		.body("login")
		.then()
		.statusCode(200)
		.and()
		.body("message", Matchers.equalTo("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema/LoginResponseSchema.json"));
			}

}
