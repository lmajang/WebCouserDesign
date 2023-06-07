package com.example.springboot.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.ClassDao;
import com.example.springboot.Dao.CollegeDao;
import com.example.springboot.Pojo.ClassPojo;
import com.example.springboot.Pojo.CollegePojo;
import com.example.springboot.Pojo.MajorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl {
    @Autowired
    ClassDao classDao;

    public List<ClassPojo> findAllById(){return classDao.selectList(new QueryWrapper<>());}



    public List<ClassPojo> findByAcademy(String academy){
        QueryWrapper<ClassPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("academy",academy);
        List<ClassPojo> list=classDao.selectList(wrapper);
        return list;
    }
}
