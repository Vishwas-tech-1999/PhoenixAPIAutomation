package com.api.tests;

import com.api.Constants.Role;
import com.api.pojo.CreatejobApiPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.api.utilities.AuthTokenProvider;
import com.api.utilities.ConfigManager;
import com.api.utilities.specUtil;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateJobAPITest {
	
	
	@Test
	public void createJobApiTest() throws IOException {
		
		Customer customer = new Customer("Hildegard","Gleason", "279-968-7176", "856-222-3192", "Brooklyn_Kilback43@hotmail.com", "");
		System.out.println(customer.first_name());
		CustomerAddress cutomerAddress = new CustomerAddress("55", "a", "puram", "near park", "Mumbai", "523566", "India", "India");
		CustomerProduct customerProduct = new CustomerProduct("2025-10-19T18:30:00.000Z", "61409158184526", "64409158184526", "61409158184526", "2025-10-19T18:30:00.000Z", 3, 3);
		Problems problems = new Problems(2, "A");
		List<Problems> problems1 =new ArrayList<Problems>();
		problems1.add(problems);
		
		
		CreatejobApiPayload createJobPayload = new CreatejobApiPayload(0, 2, 2, 2, customer, cutomerAddress, customerProduct, problems1);
		
		given().spec(specUtil.requestSpec(Role.FD,createJobPayload))
		.when().post("/job/create").then().spec(specUtil.responseSpec_Ok()).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\createAPIresponseSchema.json"))
		.body("message", Matchers.equalTo("Job created successfully. "))
		.body("data.mst_service_location_id", Matchers.notNullValue())
		.body("data.job_number", Matchers.startsWith("JOB_"));
	}

}
