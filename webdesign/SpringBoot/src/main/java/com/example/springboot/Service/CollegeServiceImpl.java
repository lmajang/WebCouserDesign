package com.example.springboot.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.AdminDao;
import com.example.springboot.Dao.CollegeDao;
import com.example.springboot.Pojo.CollegePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl {
    @Autowired
    CollegeDao collegeDao;

    public List<CollegePojo> findAllById(){return collegeDao.selectList(new QueryWrapper<>());}
}
