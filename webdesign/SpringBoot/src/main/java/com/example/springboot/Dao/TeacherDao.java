package com.example.springboot.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Pojo.TeacherPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherDao extends BaseMapper<TeacherPojo> {
}