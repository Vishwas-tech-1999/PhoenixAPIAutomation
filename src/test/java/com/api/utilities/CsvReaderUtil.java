package com.api.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvReaderUtil {

	private CsvReaderUtil() {

	}

	public static <T> Iterator<T> loadCsvile(String pathOfCsvFile, Class<T> bean) throws IOException, CsvException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCsvFile);

		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader = new CSVReader(isr);
		
		/*List<String[]> rows = csvreader.readAll();

	    System.out.println("======= RAW CSV DATA =======");

	    for(String[] row : rows) {

	        for(String value : row) {
	            System.out.print(value + " | ");
	        }

	        System.out.println();
	    }

	    System.out.println("============================");
	    */

		CsvToBean<T> csvToBean = new CsvToBeanBuilder(csvreader).withType(bean)
				.withIgnoreEmptyLine(true).build();
		
		List<T> list = csvToBean.parse();
		
		return list.iterator();
	}

}
