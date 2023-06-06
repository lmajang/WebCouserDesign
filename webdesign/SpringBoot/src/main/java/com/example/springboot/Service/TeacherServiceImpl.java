package com.example.springboot.Service;

import com.example.springboot.Dao.TeacherDao;
import com.example.springboot.Pojo.TeacherPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl {
    @Autowired
    TeacherDao teacherDao;

    public TeacherPojo findTeacherById(String id){return teacherDao.selectById(id);}
}
