package com.managedCare.salesOperation.enquiry.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_enquiry")
public class EnquiryDetailList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ENQUIRY_ID", nullable = false)
	private int enquiryId;
	@Column(name = "enquiry_num", unique = true,nullable = false)
	public String enquiryNum;
	@Column(name = "Title", nullable = false)
	private String title;
	@Column(name = "CALLER_NAME", nullable = false)
	private String callerName;
	@Column(name="enquiry_type_id") 
	private int enquiryTypeId;
	@Column(name = "status",nullable = false)
	private String status;
	@Column(name = "lead_time", nullable = true)
	private String leadTime;

}
