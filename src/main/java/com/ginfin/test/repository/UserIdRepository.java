package com.ginfin.test.repository;

import com.ginfin.test.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdRepository extends JpaRepository<UserId,Integer> {
}
