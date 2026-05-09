package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.Constants.Role;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;
import com.api.utilities.specUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class MasterAPITest {

	@Test
	public void msterAPITest() throws IOException {
		given().spec(specUtil.requestSpecWithAuth(Role.FD)).when()
				.post("master").then().spec(specUtil.responseSpec_Ok())
				.body("message", Matchers.equalTo("Success")).body("data", Matchers.notNullValue())
				.body("data", Matchers.hasKey("mst_model")).body("$", Matchers.hasKey("message"))
				.body("$", Matchers.hasKey("message")).body("data.mst_oem.size()", Matchers.greaterThanOrEqualTo(2))
				.body("data.mst_oem.id", Matchers.everyItem(Matchers.notNullValue()))
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema/masterAPIResponseSchema.json"));
	}

	@Test
	public void masterApi_MissAuth() {
		given().spec(specUtil.requestSpec()).when().post("master").then().spec(specUtil.responseSpec_UnAuth_text(401));
	}

}
