package com.api.utilities;

import java.util.Iterator;

import com.dataproviders.api.bean.CreateJobBean;

public class Demo {

	public static void main(String[] args) {
Iterator<CreateJobBean> iterator = CsvReaderUtil.loadCsvile("testData\\createJobApiData.csv", CreateJobBean.class);

while(iterator.hasNext())
{
	System.out.println(iterator.next());
}
	}

}
