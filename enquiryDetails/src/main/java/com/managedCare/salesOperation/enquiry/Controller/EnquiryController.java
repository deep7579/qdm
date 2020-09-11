package com.managedCare.salesOperation.enquiry.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.managedCare.salesOperation.enquiry.Common.Response.CommonResponseInsert;
import com.managedCare.salesOperation.enquiry.Request.ContactDetailsDTO;
import com.managedCare.salesOperation.enquiry.Request.EnquiryEditRequestDTO;
import com.managedCare.salesOperation.enquiry.Request.EnquiryRequestDTO;
import com.managedCare.salesOperation.enquiry.Response.EnquiryResponseDTO;
import com.managedCare.salesOperation.enquiry.Response.EnquiryStatusResponse;
import com.managedCare.salesOperation.enquiry.Service.EnquiryDetailService;

@RestController
@RequestMapping("qdm/enquiry")
public class EnquiryController{
	
	@Autowired
	private EnquiryDetailService enquiryDetail;
	@Autowired
	private CommonResponseInsert commonResponse;
	@PostMapping("/entity/add")
	public ResponseEntity<CommonResponseInsert> addEnquiry(@RequestBody EnquiryRequestDTO enquiryRequest) {
		 enquiryDetail.createEnquiry(enquiryRequest);
		 commonResponse.setData(null);
		 commonResponse.setMessage("Successfully Created");
		 commonResponse.setStatusCode(HttpStatus.CREATED);
		 commonResponse.setStatus("Success");
		return new ResponseEntity<CommonResponseInsert>(commonResponse, HttpStatus.CREATED);
	}
	@PutMapping("/entity/edit/{id}")
	public ResponseEntity<CommonResponseInsert> editEnquiry(@PathVariable("id") int id,@RequestBody EnquiryEditRequestDTO enquiryRequest) {
			enquiryDetail.editEnquery(id,enquiryRequest);
			commonResponse.setData(null);
			commonResponse.setMessage("Successfully Updated");
			commonResponse.setStatusCode(HttpStatus.ACCEPTED);
			commonResponse.setStatus("Success");
			return new ResponseEntity<CommonResponseInsert>(commonResponse, HttpStatus.ACCEPTED);
	}
	@GetMapping("/customerSupport/getAllFirstName")
	public ResponseEntity<List<String>> getAllcustomerSupportFirstName(){
		List<String> firstNameCustomerSupport = null;
		firstNameCustomerSupport = enquiryDetail.getAllCustomerSupportFirstName();
		return new ResponseEntity<List<String>>(firstNameCustomerSupport,HttpStatus.OK);
	}
	@GetMapping("/customerSupport/assign/getAllFirstName")
	public ResponseEntity<List<String>> getAllassignedToFirstName(){
		List<String> firstNameCustomerSupport = null;
		firstNameCustomerSupport = enquiryDetail.getAllassignedToFirstName();
		return new ResponseEntity<List<String>>(firstNameCustomerSupport,HttpStatus.OK);
	}
	@PostMapping("/customerSupport/add/contact")
	public ResponseEntity<CommonResponseInsert> addContact(@RequestBody ContactDetailsDTO contactDetails){
		 int idCreated= enquiryDetail.createContact(contactDetails);
		 if(idCreated!= 0) {
			 commonResponse.setData(null);
			 commonResponse.setMessage("Successfully Created");
			 commonResponse.setStatusCode(HttpStatus.CREATED);
			 commonResponse.setStatus("Success");
		 }else {
			 commonResponse.setError("Request Failed");
		 }
		 return new ResponseEntity<CommonResponseInsert>(commonResponse,HttpStatus.CREATED);
	}
	@GetMapping("/customerSupport/getFullNamewithSal")
	public ResponseEntity<List<String>> getFullNamewithSal(){
		List<String> fullName = null;
		fullName = enquiryDetail.getFullNameWithTitle();
		return new ResponseEntity<List<String>>(fullName,HttpStatus.OK);
	}
	@GetMapping("/referral/getALLName")
	public ResponseEntity<List<String>> getAllReferralName(){
		List<String> referralName = null;
		referralName=enquiryDetail.getAllReferralName();
		return new ResponseEntity<List<String>>(referralName,HttpStatus.OK);
	}
	@GetMapping("/customerSupport/getAllRelationship")
	public ResponseEntity<List<String>> getAllRelationship(){
		List<String> relationship = null;
		relationship = enquiryDetail.getAllRelationship();
		return new ResponseEntity<List<String>>(relationship,HttpStatus.OK);
	}
	@GetMapping(value="/entity/get/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EnquiryResponseDTO> getEnquiry(@PathVariable("id") int id, EnquiryResponseDTO response) {
		EnquiryResponseDTO enquiryResponse = enquiryDetail.getEnquiryById(id,response);
		return new ResponseEntity<EnquiryResponseDTO>(enquiryResponse,HttpStatus.OK);
	}
	@GetMapping("/customerSupport/getAllEnquiryType")
	public ResponseEntity<List<String>> getAllEnquiryType(){
		List<String> enquiryType = null;
		enquiryType= enquiryDetail.getAllEnquiryTypeName();
		return new ResponseEntity<List<String>>(enquiryType,HttpStatus.OK);
	}
	@GetMapping("/enquiry/getViewAll/{pageNo}/{pageSize}")
	public ResponseEntity<EnquiryStatusResponse> getViewAllEnquiry(@PathVariable("pageSize") int pageSize,@PathVariable("pageNo") int pageNo
			,@RequestParam(value = "sortDirec", defaultValue="desc",required = false) String sortDirec,
			@RequestParam(value = "sortfield", defaultValue="created_Date",required = false) String sortfield) {
		EnquiryStatusResponse enquiry = enquiryDetail.getAllEnquiry(pageSize, pageNo,sortDirec,sortfield);
		return new ResponseEntity<EnquiryStatusResponse>(enquiry, HttpStatus.OK);
	}
}
