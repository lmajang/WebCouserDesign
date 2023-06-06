package com.example.springboot.Service;

import com.example.springboot.Dao.StudentDao;
import com.example.springboot.Pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
    @Autowired
    StudentDao studentDao;

    public StudentPojo findStudentById(String id){return studentDao.selectById(id);}

    }
}
