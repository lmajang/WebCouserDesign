package com.example.springboot.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.pojo.AdminPojo;
import jdk.jfr.DataAmount;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdminDao extends BaseMapper<AdminPojo> {
}
