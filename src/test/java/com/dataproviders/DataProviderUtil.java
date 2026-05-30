package com.dataproviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.utilities.CreateJobBeanMapper;
import com.api.utilities.CsvReaderUtil;
import com.database.dao.CreateJobApiPayloadDataDao;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;
import com.opencsv.exceptions.CsvException;

public class DataProviderUtil {

	@DataProvider(name="LoginAPIDataProvider", parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() throws IOException, CsvException {
		return CsvReaderUtil.loadCsvile("testData\\testData.csv", UserBean.class);
	}
	
	@DataProvider(name="CreateJobAPIDataProvider", parallel=true)
	public static Iterator<CreatejobApiPayload> createJobApiDataProvider() throws IOException, CsvException {
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
	
	@DataProvider(name="CreateJobAPIDBDataProvider", parallel=true)
	public static Iterator<CreatejobApiPayload> createJobApiDBDataProvider() {
		List<CreateJobBean> beanlist = CreateJobApiPayloadDataDao.getCreteJobPayloadData();
		ArrayList<CreatejobApiPayload> payloadList = new ArrayList<CreatejobApiPayload>();
		for(CreateJobBean createJobBean : beanlist) {
			CreatejobApiPayload payload = CreateJobBeanMapper.mapper(createJobBean);
			payloadList.add(payload);
		}
		return payloadList.iterator();
	}
}
