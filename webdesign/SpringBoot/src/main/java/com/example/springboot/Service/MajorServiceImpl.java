package com.example.springboot.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.CollegeDao;
import com.example.springboot.Dao.MajorDao;
import com.example.springboot.Pojo.CollegePojo;
import com.example.springboot.Pojo.MajorPojo;
import com.example.springboot.Pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl {
    @Autowired
    MajorDao majorDao;
    public List<MajorPojo> findAllById(){return majorDao.selectList(new QueryWrapper<>());}

    public List<MajorPojo> findByAcademy(String academy){
        QueryWrapper<MajorPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("academy",academy);
        List<MajorPojo> list=majorDao.selectList(wrapper);
        return list;
    }
}
