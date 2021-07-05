package com.ginfin.test.repository;

import com.ginfin.test.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findFirstByOrderByIdDesc();

    void deleteById(Integer id);
}
