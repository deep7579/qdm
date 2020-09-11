package com.managedCare.salesOperation.enquiry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.managedCare.salesOperation.enquiry.Entity.GetEnquiry;

@Repository
public interface GetEnquiryDetailsRepository extends JpaRepository<GetEnquiry, Integer>{
	@Query(value = "Select enquiry_id,address,ambulation,bathing,bed_mobility,caller_name,code,complain,created_date,doc_seen,feeding,grooming,height,med_hist,mobile_number,recommendation,rehab_criteria,service_preferred,title,toileting,transfer,weight,caller_id,tb_referral_id,relationship_id from tb_enquiry where enquiry_id= :id",nativeQuery=true)
	GetEnquiry findEnquiryById(int id);
}
