package com.example.springboot.Dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Pojo.CollegePojo;
import com.example.springboot.Pojo.MajorPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MajorDao extends BaseMapper<MajorPojo> {
}
