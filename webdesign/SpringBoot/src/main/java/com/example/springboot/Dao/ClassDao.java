package com.example.springboot.Dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Pojo.ClassPojo;
import com.example.springboot.Pojo.CollegePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassDao extends BaseMapper<ClassPojo> {
}
