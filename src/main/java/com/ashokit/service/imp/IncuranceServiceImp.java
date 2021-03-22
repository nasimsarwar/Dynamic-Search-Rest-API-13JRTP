package com.ashokit.service.imp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ashokit.dto.IncuranceDTO;
import com.ashokit.entity.IncuranceEntity;
import com.ashokit.repository.IncuranceRepository;
import com.ashokit.service.IncuranceService;

@Component
@Service
public class IncuranceServiceImp implements IncuranceService {

	@Autowired
	IncuranceRepository incuranceRepository;

	@Override
	public IncuranceDTO createIncurance(IncuranceDTO detail) {
		IncuranceEntity incEntity = new IncuranceEntity();
		BeanUtils.copyProperties(detail, incEntity);
		IncuranceEntity storedIncEntity = incuranceRepository.save(incEntity);
		IncuranceDTO returnValue = new IncuranceDTO();
		BeanUtils.copyProperties(storedIncEntity, returnValue);
		return returnValue;
	}

	@Override
	public List<IncuranceDTO> getAllDetails2() {
		List<IncuranceEntity> listEntity = new ArrayList<IncuranceEntity>();
	     listEntity = incuranceRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceDTO>>() {
		}.getType();
		List<IncuranceDTO> returnValue = modelMapper.map(listEntity, listType);

		return returnValue;
	}

	@Override
	public List<IncuranceDTO> getDetailsByPlanStatus(String planStatus) {
		List<IncuranceEntity> listEntity = new ArrayList<IncuranceEntity>();
		List<IncuranceEntity> planStatusEntity = new ArrayList<IncuranceEntity>();
		//listEntity =incuranceRepository.findByPlanName(planName);
		listEntity = incuranceRepository.findAll();
		for(IncuranceEntity e :listEntity ) {
			if(e.getPlanStatus().equals(planStatus)) {
				planStatusEntity.add(e);
			}	
		}
		System.out.println(planStatusEntity);
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceDTO>>() {}.getType();
		List<IncuranceDTO> returnValue = modelMapper.map(planStatusEntity, listType);

		return returnValue;
		
		
		
	}

	@Override
	public List<IncuranceDTO> getDetailsByPlanName(String planName) {
		List<IncuranceEntity> listEntity = new ArrayList<IncuranceEntity>();
		List<IncuranceEntity> planNameEntity = new ArrayList<IncuranceEntity>();
		//listEntity =incuranceRepository.findByPlanName(planName);
		listEntity = incuranceRepository.findAll();
		for(IncuranceEntity e :listEntity ) {
			if(e.getPlanName().equals(planName)) {
				planNameEntity.add(e);
			}
		}
		System.out.println(planNameEntity);
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<IncuranceDTO>>() {}.getType();
		List<IncuranceDTO> returnValue = modelMapper.map(planNameEntity, listType);

		return returnValue;
		

	}

	@Override
	public List<IncuranceDTO> getDetailByPlanNameAndPlanStatus(String planName, String planStatus) {
		List<IncuranceEntity> listEntity = new ArrayList<IncuranceEntity>();
		List<IncuranceEntity> planNameStatusEntity = new ArrayList<IncuranceEntity>();
		//listEntity =incuranceRepository.findByPlanName(planName);
		listEntity = incuranceRepository.findAll();
		for(IncuranceEntity e :listEntity ) {
			if(e.getPlanName().equals(planName) && ( e.getPlanStatus().equals(planStatus))) {
				planNameStatusEntity.add(e);
			}
			
			
		}
		System.out.println("=================String planName, String planStatus===========================");
		System.out.println(planNameStatusEntity);
		return null;
	
	}

}
