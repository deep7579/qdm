package com.managedCare.salesOperation.enquiry.Response;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryListResponseDetails {
	private int enquiryId;
	private String enquiryNum;
	private String title;
	private String callerName;
	private int enquiryTypeId;
	private String status;
	private String leadTime;
}
