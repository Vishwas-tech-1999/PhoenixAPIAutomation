package com.api.utilities;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.joda.time.Instant;
import org.testng.annotations.Test;

public class TimeUtil {

	
	public static  String getDaysAgo(int days) {

		
		String instant = Instant.now().minus(7).toString();
		System.out.println(instant);
		return instant;
	}

}
