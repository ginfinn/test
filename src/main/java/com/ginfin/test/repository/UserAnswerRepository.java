package com.ginfin.test.repository;

import com.ginfin.test.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Integer> {
    UserAnswer findFirstByOrderByIdDesc();
    List<UserAnswer> findAllByUserId(Integer userId);
}
