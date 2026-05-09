package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utilities.ConfigManager;
import com.api.utilities.specUtil;

import static com.api.utilities.ConfigManagerOld.*;

import io.restassured.module.jsv.JsonSchemaValidator;


public class LoginApiTest {
	
	@Test
	public void loginApiTest() throws IOException {
		
		
		System.getProperty("----------------"+"env");
		
		UserCredentials user = new UserCredentials("iamfd", "password");
		
		given().spec(specUtil.requestSpec(user))
		.when()
		.post("login")
		.then()
.spec(specUtil.responseSpec_Ok())
		.body("message", Matchers.equalTo("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema/LoginResponseSchema.json"));
			}

}
