package com.api.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCsvFileMapToPojo {

	public static void main(String[] args) throws IOException, CsvException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData.csv");

		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader = new CSVReader(isr);

		//List<String[]> csvdata = csvreader.readAll();

		CsvToBean<UserPojo> csvToBean = new CsvToBeanBuilder(csvreader).withType(UserPojo.class)
				.withIgnoreEmptyLine(true).build();

		List<UserPojo> userlist = csvToBean.parse();
		System.out.println(userlist);
		 System.out.println(userlist.get(0).getUsername());

	}

}
