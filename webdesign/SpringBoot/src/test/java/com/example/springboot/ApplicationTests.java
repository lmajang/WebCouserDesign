package com.example.springboot;

import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Service.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    AdminServiceImpl adminService;

    @Test
    void contextLoads() {
        AdminPojo a=adminService.findAdminById("0100");
        String s=a.getPassword();
        System.out.println(s);
    }

}
