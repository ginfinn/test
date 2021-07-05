package com.ginfin.test.repository;

import com.ginfin.test.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
Interview findByName(String name);
void  deleteById(Integer id);
}
