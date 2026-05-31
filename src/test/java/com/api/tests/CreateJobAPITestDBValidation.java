package com.api.tests;

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
import com.database.dao.CustomerDao;
import com.database.model.CustomerDBModel;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateJobAPITestDBValidation {
	private CreatejobApiPayload createJobPayload;
	private Customer customer;
	
	@BeforeMethod(description = "Constructing payload for creat job api")
	public void setup() {
		 customer = new Customer("Hildegard","Gleason", "279-968-7176", "856-222-3192", "Brooklyn_Kilback43@hotmail.com", "");
		System.out.println(customer.first_name());
		CustomerAddress cutomerAddress = new CustomerAddress("55", "a", "puram", "near park", "Mumbai", "523566", "India", "Maharashtra");
		CustomerProduct customerProduct = new CustomerProduct(TimeUtil.getDaysAgo(10), "814091581845272", "814091581845272", "814091581845272", TimeUtil.getDaysAgo(10), Product.PIXEL.getCode(), Model.GALAXY.getCode());
		Problems problems = new Problems(Problem.MICROSD_CARD_IS_NOT_WORKING_ON_YOUR_PHONE.getCode(), "A");
		List<Problems> problems1 =new ArrayList<Problems>();
		problems1.add(problems);
		
		
		 createJobPayload = new CreatejobApiPayload(ServiceLocation.ServiceLocationA.getCode(), Platform.FrontDesk.getCode(), WarrantyStatus.INWARRNTY.getCode(), Oem.Apple.getCode(), customer, cutomerAddress, customerProduct, problems1);
		
	}
	@Test(description = "Verify userdetails API Response", groups= {"API","SMOKE", "REGRESSION"})
	public void createJobApiTest() throws IOException {
		
		
		int customerid = given().spec(specUtil.requestSpec(Role.FD,createJobPayload))
				.when().post("/job/create").then().spec(specUtil.responseSpec_Ok()).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\createAPIresponseSchema.json"))
				.body("message", Matchers.equalTo("Job created successfully. "))
				.body("data.mst_service_location_id", Matchers.notNullValue())
				.body("data.job_number", Matchers.startsWith("JOB_"))
				.extract().body().jsonPath().getInt("data.tr_customer_id");
		System.out.println("******************");
		System.out.println(customerid);
		CustomerDBModel customerdatafromDb = CustomerDao.getCutomerInfo(customerid);
		System.out.println(customerdatafromDb);
		
		Assert.assertEquals(customer.first_name(), customerdatafromDb.getFirst_name());
	}

}
