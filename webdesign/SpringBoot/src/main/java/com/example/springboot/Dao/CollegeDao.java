package com.example.springboot.Dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Pojo.CollegePojo;
import com.example.springboot.Pojo.StudentPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CollegeDao extends BaseMapper<CollegePojo> {
}
