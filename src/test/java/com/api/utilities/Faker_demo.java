package com.api.utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Faker_demo {

	public static void main(String[] args) {
Faker faker = new Faker(new Locale("en-IND"));
String firstName = faker.name().firstName();
String lastName = faker.name().lastName();
System.out.println(firstName);
System.out.println(lastName);

System.out.println(faker.address().buildingNumber());
System.out.println(faker.address().streetAddress());

System.out.println(faker.numerify("998#######"));
	}

}
