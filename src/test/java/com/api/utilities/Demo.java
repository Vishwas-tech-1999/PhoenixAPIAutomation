package com.api.utilities;

import java.io.IOException;
import java.util.Iterator;

import com.dataproviders.api.bean.CreateJobBean;
import com.opencsv.exceptions.CsvException;

public class Demo {

	public static void main(String[] args) throws IOException, CsvException {
Iterator<CreateJobBean> iterator = CsvReaderUtil.loadCsvile("testData\\createJobApiData.csv", CreateJobBean.class);

while(iterator.hasNext())
{
	System.out.println(iterator.next());
}
	}

}
