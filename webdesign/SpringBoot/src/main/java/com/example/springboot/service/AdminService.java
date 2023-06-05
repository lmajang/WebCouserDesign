package com.example.springboot.service;

import com.example.springboot.dao.AdminDao;
import com.example.springboot.entity.UserAccount;
import com.example.springboot.pojo.AdminPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public AdminPojo findAdminById(String id){return adminDao.selectById(id)};
}
