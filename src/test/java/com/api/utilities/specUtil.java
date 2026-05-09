package com.api.utilities;

import static com.api.Constants.Role.ENG;

import java.io.IOException;

import org.hamcrest.Matchers;

import com.api.Constants.Role;
import com.api.pojo.UserCredentials;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specUtil {
	
	
	public static RequestSpecification requestSpec() {
		
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(ConfigManager.getProperty("BASE_URI")).setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		return request;
	}

public static RequestSpecification requestSpec(Object payload) {
		
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(ConfigManager.getProperty("BASE_URI")).setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.setBody(usercreds)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		return request;
	}
public static RequestSpecification requestSpecWithAuth(Role role) throws IOException
{
	RequestSpecification request = new RequestSpecBuilder().setBaseUri(ConfigManager.getProperty("BASE_URI")).setContentType(ContentType.JSON)
			.setAccept(ContentType.JSON)
			.addHeader("Authorization", AuthTokenProvider.getToken(role))
			.log(LogDetail.URI)
			.log(LogDetail.METHOD)
			.log(LogDetail.HEADERS)
			.log(LogDetail.BODY)
			.build();
			return request;
}

public  static ResponseSpecification responseSpec_Ok() {
	 ResponseSpecification responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
	.expectStatusCode(200)
	.expectResponseTime(Matchers.lessThan(1000L))
	.log(LogDetail.ALL).build();
	 
	 return responseSpec;
}

public  static ResponseSpecification responseSpec_UnAuth_JSON(int statuscode) {
	 ResponseSpecification responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
	.expectStatusCode(statuscode)
	.expectResponseTime(Matchers.lessThan(1000L))
	.log(LogDetail.ALL).build();
	 
	 return responseSpec;
}

public  static ResponseSpecification responseSpec_UnAuth_text(int statuscode) {
	 ResponseSpecification responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.TEXT.HTML)
	.expectStatusCode(statuscode)
	.expectResponseTime(Matchers.lessThan(1000L))
	.log(LogDetail.ALL).build();
	 
	 return responseSpec;
}
}
