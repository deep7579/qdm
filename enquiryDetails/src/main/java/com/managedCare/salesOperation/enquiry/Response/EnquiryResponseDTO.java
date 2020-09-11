package com.managedCare.salesOperation.enquiry.Response;

import java.sql.Timestamp;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class EnquiryResponseDTO {
	private String enquiryNum;
	private String title;
	private String callerName;
	private String code;
	private String mobNo;
	private String address;
	private int enquiryId;
	private Timestamp createdDate;
	private int callerId;
	private int relationshipId;
	private int referralId;
	private String complain;
	private String medicalHistory;
	private boolean docCheck;
	private String height;
	private String weight;
	private int feeding;
	private int bathing;
	private int toileting;
	private int grooming;
	private int ambulation;
	private int transfer;
	private int bedMobilty;
	private int recommendation;
	private int servicePreferred;
	private String rehabCriteria;
	private int enquiryTypeId;
	private String status;
	private String leadTime;
	

}
