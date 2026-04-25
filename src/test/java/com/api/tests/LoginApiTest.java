package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;

import io.restassured.module.jsv.JsonSchemaValidator;


public class LoginApiTest {
	
	@Test
	public void loginApiTest() {
		
		UserCredentials user = new UserCredentials("iamfd", "password");
		
		given().baseUri("http://64.227.160.186:9000/v1").
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
