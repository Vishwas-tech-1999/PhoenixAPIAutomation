package com.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.RequestModels.Customer;
import com.api.utilities.CreateJobBeanMapper;
import com.database.model.CustomerDBModel;
import com.dataproviders.api.bean.CreateJobBean;

public class DaoDemoRunner {

	public static void main(String[] args) throws SQLException {
		
		CustomerDBModel customerdata = CustomerDao.getCutomerInfo(255);
		System.out.println(customerdata);
		
		System.out.println(customerdata.getFirst_name());
		
		Customer customer = new Customer("Adalberto","Gleason", "279-968-7176", "856-222-3192", "Brooklyn_Kilback43@hotmail.com", "");
System.out.println(customer.first_name());

Assert.assertEquals(customerdata.getFirst_name(), customer.first_name());
		
		//		List<CreateJobBean> beanlist = CreateJobApiPayloadDataDao.getCreteJobPayloadData();
//		ArrayList<CreatejobApiPayload> payloadList = new ArrayList<CreatejobApiPayload>();
//		for(CreateJobBean createJobBean : beanlist) {
//			CreatejobApiPayload payload = CreateJobBeanMapper.mapper(createJobBean);
//			payloadList.add(payload);
//		}
//		System.out.println("***************************************************888");
//		for(CreatejobApiPayload paylod : payloadList) {
//			System.out.println(paylod);
//		}
	}

}
