package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

public class UserDetailsApiTest {

	
	@Test
	public void userDetaulsApiTest() {
		
		Header authHeader = new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3NzcxMDM0NTZ9.23KqSsJ8fGebo5E_AUu8IvgEuNnuf0-KT4PJ11WU-1c");
 
		given().baseUri("http://64.227.160.186:9000/v1")
		.and()
		.contentType(JSON)
		.header(authHeader)
		.when()
		.get("userdetails")
		.then().log().all().
		and().
		body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responSchema\\UserDetailsresponseSchema.json"));
	}
}
