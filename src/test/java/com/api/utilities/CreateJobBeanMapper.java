package com.api.utilities;

import java.util.ArrayList;
import java.util.List;

import com.api.RequestModels.CreatejobApiPayload;
import com.api.RequestModels.Customer;
import com.api.RequestModels.CustomerAddress;
import com.api.RequestModels.CustomerProduct;
import com.api.RequestModels.Problems;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobBeanMapper {

	private CreateJobBeanMapper() {

	}

	public static CreatejobApiPayload mapper(CreateJobBean bean) {

		String mstServiceLocationId = bean.getFmst_service_location_id();
		System.out.println("*******");
		System.out.println(bean.getFmst_service_location_id());
		System.out.println("*******");

		int mstPlatformId = Integer.parseInt(bean.getMst_platform_id());
		int warrantyStatusId = Integer.parseInt(bean.getMst_warrenty_status_id());
		int oemId = Integer.parseInt(bean.getMst_oem_id());

		Customer customer = new Customer(bean.getCustomer__first_name(), bean.getCustomer__last_name(),
				bean.getCustomer__mobile_number(), bean.getCustomer__mobile_number_alt(), bean.getCustomer__email_id(),
				bean.getCustomer__email_id_alt());

		CustomerAddress customeraddress = new CustomerAddress(bean.getCustomer_address__flat_number(),
				bean.getCustomer_address__apartment_name(), bean.getCustomer_address__street_name(),
				bean.getCustomer_address__landmark(), bean.getCustomer_address__area(),
				bean.getCustomer_address__pincode(), bean.getCustomer_address__country(),
				bean.getCustomer_address__state());

		CustomerProduct customerproduct = new CustomerProduct(bean.getCustomer_product__dop(),
				bean.getCustomer_product__serial_number(), bean.getCustomer_product__imei1(),
				bean.getCustomer_product__imei2(), bean.getCustomer_product__popurl(),
				Integer.parseInt(bean.getCustomer_product__product_id()),
				Integer.parseInt(bean.getCustomer_product__mst_model_id()));
		
		Problems problems =new Problems(Integer.parseInt(bean.getProblems__id()), bean.getProblems__remark());
		
		List<Problems> problemsList = new ArrayList<Problems>();
		problemsList.add(problems);
		CreatejobApiPayload payload = new CreatejobApiPayload(0, mstPlatformId, warrantyStatusId,
				oemId, customer, customeraddress, customerproduct, problemsList);
		
		return payload;
	}
}
