package com.carscan.Assignment.entityrepo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carscan.Assignment.entity.Assignment;
@Repository
public interface entityrepo extends JpaRepository<Assignment, Long>{
	Assignment findByfname(String name);
}
