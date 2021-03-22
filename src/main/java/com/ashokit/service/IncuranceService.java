package com.ashokit.service;

import java.util.List;

import com.ashokit.dto.IncuranceDTO;

public interface IncuranceService {
	
	IncuranceDTO createIncurance(IncuranceDTO detail);
	List<IncuranceDTO> getDetailsByPlanName(String planName);
	List<IncuranceDTO> getDetailsByPlanStatus(String planStatus);
	List<IncuranceDTO>  getAllDetails2();
	List<IncuranceDTO> getDetailByPlanNameAndPlanStatus(String planName,String planStatus);
}
