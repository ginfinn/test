package com.ginfin.test.jwt;


import com.ginfin.test.entity.Admin;
import com.ginfin.test.entity.Role;
import com.ginfin.test.repository.AdminRepository;

import com.ginfin.test.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin saveUser(Admin admin) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        admin.setRole(userRole);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin findByLogin(String login) {
        return adminRepository.findByName(login);
    }

    public Admin findByLoginAndPassword(String login, String password) {
        Admin adminEntity = findByLogin(login);
        if (adminEntity != null) {
            if (passwordEncoder.matches(password, adminEntity.getPassword())) {
                return adminEntity;
            }
        }
        return null;
    }
}