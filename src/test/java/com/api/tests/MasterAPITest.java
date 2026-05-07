package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.Constants.Role;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class MasterAPITest {

	@Test
	public void msterAPITest() throws IOException {
		given().baseUri(ConfigManager.getProperty("BASE_URI")).and()
				.header("Authorization", AuthTokenProvider.getToken(Role.FD)).and().contentType("").log().all().when()
				.post("master").then().log().all().statusCode(200).time(Matchers.lessThan(1000L))
				.body("message", Matchers.equalTo("Success")).body("data", Matchers.notNullValue())
				.body("data", Matchers.hasKey("mst_model")).body("$", Matchers.hasKey("message"))
				.body("$", Matchers.hasKey("message")).body("data.mst_oem.size()", Matchers.greaterThanOrEqualTo(2))
				.body("data.mst_oem.id", Matchers.everyItem(Matchers.notNullValue()))
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema/masterAPIResponseSchema.json"));
	}

	@Test
	public void masterApi_MissAuth() {
		given().baseUri(ConfigManager.getProperty("BASE_URI")).and().

				contentType("").log().all().when().post("master").then().log().all().statusCode(401);
	}

}
