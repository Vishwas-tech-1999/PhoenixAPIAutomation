package com.api.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.RequestModels.Customer;
import com.api.RequestModels.CustomerAddress;
import com.api.RequestModels.CustomerProduct;
import com.api.RequestModels.Problems;
import com.github.javafaker.Faker;

public class Faker_demo2 {
 private final static String COUNTRY = "INDIA";
	public static void main(String[] args) {

		Faker faker = new Faker();
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String mobileNumber = faker.numerify("709#########");
		String altmobileNumber = faker.numerify("709#########");
		String emamilAddress = faker.internet().emailAddress();
		String altemamilAddress = faker.internet().emailAddress();
		faker.internet().emailAddress();
		Customer customer = new Customer(firstName,lastName, mobileNumber, altmobileNumber, emamilAddress, altemamilAddress );
		
		
		String flatNumber = faker.address().buildingNumber();
		String apartment_name = faker.address().cityName();
		String street_name = faker.address().streetName();
		String landmark = faker.address().streetName();
		String area = faker.address().cityName();
		String pincode = faker.numerify("#####");
		String state = faker.address().state();
		CustomerAddress customeraddress = new CustomerAddress(flatNumber, apartment_name, street_name, landmark, area, pincode, COUNTRY, state);
		
		String dop = TimeUtil.getDaysAgo(10);
		
		String imei = faker.numerify("##############");
		
		String popurl = faker.internet().url();
		CustomerProduct customerProduct =new CustomerProduct(dop, imei, imei, imei, popurl, 3, 3);
		
		
	Random random = new Random();
	int id = random.nextInt(26)+1;
	
	String remark = faker.lorem().sentence(5);
		Problems problems  = new Problems(id, remark);
		
		List<Problems> problemsList = new ArrayList<Problems>();
		problemsList.add(problems);
		CreatejobApiPayload payload = new CreatejobApiPayload(0, 2, 1, 2, customer, customeraddress, customerProduct, problemsList);
		
		System.out.println(payload);
	}

}
