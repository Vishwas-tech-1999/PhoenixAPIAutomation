package com.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.utilities.CreateJobBeanMapper;
import com.api.utilities.CsvReaderUtil;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;

public class DataProviderUtil {

	@DataProvider(name="LoginAPIDataProvider", parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CsvReaderUtil.loadCsvile("testData\\testData.csv", UserBean.class);
	}
	
	@DataProvider(name="CreateJobAPIDataProvider", parallel=true)
	public static Iterator<CreatejobApiPayload> createJobApiDataProvider() {
		Iterator<CreateJobBean> createJobAPIIterator = CsvReaderUtil.loadCsvile("testData/createJobApiData.csv", CreateJobBean.class);
	
		List<CreatejobApiPayload> payloadList = new ArrayList<CreatejobApiPayload>();
		CreatejobApiPayload tempPaylod;
		CreateJobBean tempBean;
		while(createJobAPIIterator.hasNext()){
			 tempBean = createJobAPIIterator.next();
			
			 tempPaylod = CreateJobBeanMapper.mapper(tempBean);
			 
			 payloadList.add(tempPaylod);
		}
		
		return payloadList.iterator();
	
	
	}
}
