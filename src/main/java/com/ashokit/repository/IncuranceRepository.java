package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.IncuranceEntity;

@Repository
public interface IncuranceRepository extends JpaRepository<IncuranceEntity, Long> {

	IncuranceEntity findByPlanName(String name);

	IncuranceEntity findByPlanStatus(String planStatus);

}
