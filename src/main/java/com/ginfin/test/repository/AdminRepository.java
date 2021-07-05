package com.ginfin.test.repository;

import com.ginfin.test.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByName(String name);
}
