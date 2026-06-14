package com.api.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.RequestModels.Customer;
import com.api.RequestModels.CustomerAddress;
import com.api.RequestModels.CustomerProduct;
import com.api.RequestModels.Problems;
import com.github.javafaker.Faker;

public class FakerDataGenerator {
	private final  static Faker faker = new Faker(new Locale("en-IND"));
	private final  static Random RANDOM = new Random();
	 private final static String COUNTRY = "INDIA";
	 private static final int MST_SERVICE_LOCATION_ID = 0;
	 private static final int MST_PLATFORM_ID = 2;
	 private static final int MST_WARRANTY_STATUS_ID = 1;
	 private static final int MST_OEM_ID = 2;
	 
	 private static final int validProblemId[] = {1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};
	
	public static CreatejobApiPayload generateFakeCreateJobData() {
		Customer customer  =generateFakCustomerData();
		CustomerAddress customeraddress = generateCustomerAddress();
		CustomerProduct customerproduct = generateCustomerProduct();
		List<Problems> problemsList = generateProblemsList();
		CreatejobApiPayload paylod = new CreatejobApiPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRANTY_STATUS_ID, MST_OEM_ID, customer, customeraddress, customerproduct, problemsList);
	return paylod;
	}
	
	public static Iterator<CreatejobApiPayload> generateFakeCreateJobData(int count) {
		List<CreatejobApiPayload> payloadList = new ArrayList<CreatejobApiPayload>();
		for(int i=1; i<=count; i++) {
		Customer customer  =generateFakCustomerData();
		CustomerAddress customeraddress = generateCustomerAddress();
		CustomerProduct customerproduct = generateCustomerProduct();
		List<Problems> problemsList = generateProblemsList();
		CreatejobApiPayload paylod = new CreatejobApiPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRANTY_STATUS_ID, MST_OEM_ID, customer, customeraddress, customerproduct, problemsList);
		payloadList.add(paylod);
		}
		return payloadList.iterator();
	}

	private static List<Problems> generateProblemsList() {
		int count = RANDOM.nextInt(3)+1;
		String remark;
		Problems problems ;
		int id ;
		List<Problems> problemsList = new ArrayList<Problems>();
		
		for(int i=0;i<=count; i++) {
		 id = RANDOM.nextInt(validProblemId.length);
		
		 remark = faker.lorem().sentence(5);
			 problems  = new Problems(validProblemId[id], remark);
			
			
			problemsList.add(problems);
		}
		return problemsList;
	}

	private static CustomerProduct generateCustomerProduct() {
String dop = TimeUtil.getDaysAgo(10);
		
		String imei = faker.numerify("##############");
		
		String popurl = faker.internet().url();
		CustomerProduct customerProduct =new CustomerProduct(dop, imei, imei, imei, popurl, 3, 3);
		return customerProduct;
	}

	private static CustomerAddress generateCustomerAddress() {
		String flatNumber = faker.address().buildingNumber();
		String apartment_name = faker.address().cityName();
		String street_name = faker.address().streetName();
		String landmark = faker.address().streetName();
		String area = faker.address().cityName();
		String pincode = faker.numerify("#####");
		String state = faker.address().state();
		CustomerAddress customeraddress = new CustomerAddress(flatNumber, apartment_name, street_name, landmark, area, pincode, COUNTRY, state);
	return customeraddress;
	}

	private static Customer generateFakCustomerData() {
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String mobileNumber = faker.numerify("709#########");
		String altmobileNumber = faker.numerify("709#########");
		String emamilAddress = faker.internet().emailAddress();
		String altemamilAddress = faker.internet().emailAddress();
		faker.internet().emailAddress();
		Customer customer = new Customer(firstName,lastName, mobileNumber, altmobileNumber, emamilAddress, altemamilAddress );
		return customer;
	
	}
}
