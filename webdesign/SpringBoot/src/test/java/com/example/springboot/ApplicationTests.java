package com.example.springboot;

import com.alibaba.fastjson2.JSON;
import com.example.springboot.Pojo.*;
import com.example.springboot.Service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    ClassServiceImpl classService;
    @Autowired
    MajorServiceImpl majorService;
    @Test
    void contextLoads() {
        TeacherPojo answer=teacherService.findTeacherById("0000");
        String academy= answer.getAcademy();
        List<StudentPojo> list = studentService.findByAcademy(academy);
        String result = JSON.toJSONString(list);
        System.out.println(result);
    }

}
