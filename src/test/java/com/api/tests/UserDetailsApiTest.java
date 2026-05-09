package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import java.io.IOException;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

import com.api.utilities.ConfigManagerOld;
import com.api.utilities.specUtil;

import static com.api.Constants.Role.*;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;

public class UserDetailsApiTest {

	
	@Test(description = "Verify userdetails API Response", groups= {"API","SMOKE", "REGRESSION"})
	public void userDetaulsApiTest() throws IOException {
		
		//Header authHeader = new Header("Authorization", AuthTokenProvider.getToken(ENG));
 
		given().spec(specUtil.requestSpecWithAuth(FD))
		.when()
		.get("userdetails")
		.then().spec(specUtil.responseSpec_Ok()).
		body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\UserDetailsresponseSchema.json"));
	}
}
