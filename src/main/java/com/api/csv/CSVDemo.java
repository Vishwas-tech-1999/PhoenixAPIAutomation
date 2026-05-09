package com.api.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVDemo {

	public static void main(String[] args) throws IOException, CsvException {
		
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData.csv");
//		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\RA_Phoenix_Test_Automation_Framework\\src\\main\\resources\\testData.csv");
//		
//		FileReader fr = new FileReader(file);
				
				InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader =new CSVReader(isr);
		
		List<String[]> csvdata = csvreader.readAll();
		
		System.out.println(csvdata);
		
		for(String[] dataArray : csvdata )
		{
			for(String data :dataArray)
			{
				System.out.print(data + " ");
			}
			
			System.out.println("");
		}
	}

}
