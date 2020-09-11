package com.managedCare.salesOperation.enquiry.Response;

import java.util.List;

import lombok.Data;

@Data
public class EnquiryStatusResponse {
	private List<EnquiryListResponseDetails> enquiryStatusResponse;
	private Integer offset;

}
