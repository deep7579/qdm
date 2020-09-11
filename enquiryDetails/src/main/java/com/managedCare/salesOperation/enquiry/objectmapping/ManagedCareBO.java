package com.managedCare.salesOperation.enquiry.objectmapping;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import com.managedCare.salesOperation.enquiry.Entity.EnquiryDetailList;
import com.managedCare.salesOperation.enquiry.Response.EnquiryListResponseDetails;
import com.managedCare.salesOperation.enquiry.Response.EnquiryStatusResponse;

@Component
public class ManagedCareBO {

	@PersistenceContext
	private EntityManager em;

	public EnquiryStatusResponse mapService(List<EnquiryDetailList> list, int pageNo) {

		EnquiryStatusResponse objServicesList = new EnquiryStatusResponse();
		objServicesList.setOffset(pageNo);
		List<EnquiryListResponseDetails> listEnquiry = new ArrayList<EnquiryListResponseDetails>();
		for (EnquiryDetailList beanEnquiry : list) {
			EnquiryListResponseDetails details = new EnquiryListResponseDetails();
			details.setEnquiryId(beanEnquiry.getEnquiryId());
			details.setEnquiryNum(beanEnquiry.getEnquiryNum());
			details.setTitle(beanEnquiry.getTitle());
			details.setCallerName(beanEnquiry.getCallerName());
			details.setStatus(beanEnquiry.getStatus());
			//details.setEnquiryTypeId(beanEnquiry.getEnquiryTypeId());
			details.setLeadTime(beanEnquiry.getLeadTime());
			listEnquiry.add(details);
		}
		objServicesList.setEnquiryStatusResponse(listEnquiry);

		return objServicesList;

	}

	
}
