package com.example.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.AdminDao;
import com.example.springboot.Pojo.AdminPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {
    @Autowired
    AdminDao adminDao;

    public AdminPojo findAdminById(String id){return adminDao.selectById(id);}

    public void addAdmin(String id,String name,String password,String role){
        adminDao.insert(new AdminPojo(id,name,password,role));
    }
    public void xiaojichange(String password){
        AdminPojo adminPojo=new AdminPojo();
        adminPojo.setPassword(password);
        QueryWrapper<AdminPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("role","校级管理员");
        adminDao.update(adminPojo, wrapper);
    }

    public void yuanjichange(String password){
        AdminPojo adminPojo=new AdminPojo();
        adminPojo.setPassword(password);
        QueryWrapper<AdminPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("role","院级管理员");
        adminDao.update(adminPojo, wrapper);
    }
}
