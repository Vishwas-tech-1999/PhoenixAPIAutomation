package com.api.tests.dataDriven;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.RequestModels.UserCredentials;
import com.api.utilities.ConfigManager;
import com.api.utilities.specUtil;
import com.dataproviders.api.bean.UserBean;

import static com.api.utilities.ConfigManagerOld.*;

import io.restassured.module.jsv.JsonSchemaValidator;



public class LoginApiDataDrivenTest {
	
	private UserCredentials user;
	
	@BeforeMethod(description = "Creation payload for login API")
	public void setup() {
		 user = new UserCredentials("iamfd", "password");
	}

	
	@Test (description = "Verify Login APAi is working for FD user", groups= {"api", "Smoke", "Regression"},
	dataProviderClass = com.dataproviders.DataProviderUtil.class,
	dataProvider = "LoginAPIDataProvider"
			)
	public void loginApiTest(UserBean userbean) throws IOException {
		
		
		System.getProperty("----------------"+"env");
		

		
		given().spec(specUtil.requestSpec(userbean))
		.when()
		.post("login")
		.then()
.spec(specUtil.responseSpec_Ok())
		.body("message", Matchers.equalTo("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema/LoginResponseSchema.json"));
			}

}
