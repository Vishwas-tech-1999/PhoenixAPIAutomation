package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.security.AuthProvider;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.Constants.Role;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;
import com.api.utilities.specUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CountApiTest {
	
	@Test
	public void verifyCountAPiResponse() throws IOException {
		given().spec(specUtil.requestSpecWithAuth(Role.FD))
		.when().get("/dashboard/count").then().spec(specUtil.responseSpec_Ok())
		.body("message", Matchers.equalTo("Success"))
		.and()
		.body("data", Matchers.notNullValue())
		.time(Matchers.lessThan(2000L))
		.body("data.size()", Matchers.greaterThanOrEqualTo(3))
		.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\CountApiResponseSchema.json"))
		.body("data.key", Matchers.containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment" ))
		.body("data.label", Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())));
	}
	
	@Test
	public void countApiTest_missingAuth() throws IOException {
		given().spec(specUtil.requestSpec())
		.when().get("/dashboard/count").then().spec(specUtil.responseSpec_UnAuth_text(401));
	}

	

}
