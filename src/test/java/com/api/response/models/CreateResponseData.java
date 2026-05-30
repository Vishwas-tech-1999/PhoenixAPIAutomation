package com.api.response.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class CreateResponseData {
	
	private int id;
	private int mst_service_location_id;
	private int mst_platform_id;
	private int  mst_warrenty_status_id;
	private int  mst_oem_id;
	private int  tr_customer_id;
	private int tr_customer_product_id;
	private String  job_number;

}
