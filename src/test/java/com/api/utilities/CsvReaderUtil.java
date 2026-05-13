package com.api.utilities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.api.dataproviders.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvReaderUtil {

	private CsvReaderUtil() {
		
	}
	public static void main(String[] args) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData.csv");

		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader = new CSVReader(isr);

		CsvToBean<UserBean> csvToBean = new CsvToBeanBuilder(csvreader).withType(UserBean.class)
				.withIgnoreEmptyLine(true).build();

		List<UserBean> userlist = csvToBean.parse();
		System.out.println(userlist);
		System.out.println(userlist.get(0).getUsername());
	}

}
