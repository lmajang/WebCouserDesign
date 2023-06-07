package com.example.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.StudentDao;
import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Pojo.MajorPojo;
import com.example.springboot.Pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {
    @Autowired
    StudentDao studentDao;

    public StudentPojo findStudentById(String id){return studentDao.selectById(id);}

    public List<StudentPojo> findAllById(){return studentDao.selectList(new QueryWrapper<>());}

    public void addStudent(String Sname,String Sidcard,String Sno,String academy,
                           String major,String class1,String health,boolean daily){
        studentDao.insert(new StudentPojo(Sname,Sidcard,Sno,academy,major,class1,health,daily));
    }
    public void delStudent(String Sno){
        studentDao.deleteById(Sno);
    }
    public void updateStudent(String Sno,String academy,String major,String class1){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setAcademy(academy);
        studentPojo.setMajor(major);
        studentPojo.setClass1(class1);
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Sno",Sno);
        studentDao.update(studentPojo,wrapper);
    }
    public List<StudentPojo> findByAcademy(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("academy",academy);
        List<StudentPojo> list=studentDao.selectList(wrapper);
        return list;
    }
}
