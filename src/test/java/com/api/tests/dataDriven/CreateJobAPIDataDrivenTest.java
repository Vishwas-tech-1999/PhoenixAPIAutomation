package com.api.tests.dataDriven;

import com.api.Constants.Model;
import com.api.Constants.Oem;
import com.api.Constants.Platform;
import com.api.Constants.Problem;
import com.api.Constants.Product;
import com.api.Constants.Role;
import com.api.Constants.ServiceLocation;
import com.api.Constants.WarrantyStatus;
import com.api.RequestModels.CreatejobApiPayload;
import com.api.RequestModels.Customer;
import com.api.RequestModels.CustomerAddress;
import com.api.RequestModels.CustomerProduct;
import com.api.RequestModels.Problems;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;
import com.api.utilities.TimeUtil;
import com.api.utilities.specUtil;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateJobAPIDataDrivenTest {
	
	
	@Test(description = "Verify create API Response", groups= {"API","SMOKE", "REGRESSION", "csv"}, dataProviderClass = com.dataproviders.DataProviderUtil.class,
			dataProvider = "CreateJobAPIDataProvider")
	public void createJobApiTest(CreatejobApiPayload payload) throws IOException {
		
		
		given().spec(specUtil.requestSpec(Role.FD,payload))
		.when().post("/job/create").then().spec(specUtil.responseSpec_Ok()).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\createAPIresponseSchema.json"))
		.body("message", Matchers.equalTo("Job created successfully. "))
		.body("data.mst_service_location_id", Matchers.notNullValue())
		.body("data.job_number", Matchers.startsWith("JOB_"));
	}

}
