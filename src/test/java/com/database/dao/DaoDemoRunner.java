package com.database.dao;

import java.util.ArrayList;
import java.util.List;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.utilities.CreateJobBeanMapper;
import com.dataproviders.api.bean.CreateJobBean;

public class DaoDemoRunner {

	public static void main(String[] args) {
		List<CreateJobBean> beanlist = CreateJobApiPayloadDataDao.getCreteJobPayloadData();
		ArrayList<CreatejobApiPayload> payloadList = new ArrayList<CreatejobApiPayload>();
		for(CreateJobBean createJobBean : beanlist) {
			CreatejobApiPayload payload = CreateJobBeanMapper.mapper(createJobBean);
			payloadList.add(payload);
		}
		System.out.println("***************************************************888");
		for(CreatejobApiPayload paylod : payloadList) {
			System.out.println(paylod);
		}
	}

}
