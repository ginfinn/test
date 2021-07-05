package com.ginfin.test;

import com.ginfin.test.entity.Admin;
import com.ginfin.test.entity.Role;
import com.ginfin.test.repository.AdminRepository;
import com.ginfin.test.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(RoleRepository repository) {
        return (args) -> {
            repository.save(new Role(1, "ROLE_ADMIN"));


        };
    }
    @Bean
    public CommandLineRunner loadDataAdmin(AdminRepository repository) {
        return (args) -> {
            repository.save(new Admin(1,"admin","$2y$12$I4iEbJSkaVpfL7eWJTca8elTS0EygS4Rxx.slfmrBqhHTwSAsz3LK",new Role(1,"ROLE_ADMIN")));


        };
    }
}