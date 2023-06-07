package com.example.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.StudentDao;
import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Pojo.MajorPojo;
import com.example.springboot.Pojo.StudentPojo;
import com.example.springboot.Pojo.TeacherPojo;
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
                           String major,String class1,String health,int daily,int daycount){
        studentDao.insert(new StudentPojo(Sname,Sidcard,Sno,academy,major,class1,health,daily,daycount));
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

    public void updatehealth(String Sno,String health){
        StudentPojo studentrPojo=new StudentPojo();
        studentrPojo.setHealth(health);
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Sno",Sno);
        studentDao.update(studentrPojo,wrapper);
    }
    public void updatedaily(String Sno,int daily){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setDaily(daily);
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Sno",Sno);
        studentDao.update(studentPojo,wrapper);
    }

    public void updatedaycount(String Sno,int daycount){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setDaycount(daycount);
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Sno",Sno);
        studentDao.update(studentPojo,wrapper);
    }
    public Long GreenCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","绿色");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long RedCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","红色");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long BlueCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","蓝色");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long YellowCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","黄色");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long GreyCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","灰色");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long YesCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","1");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long NoCount(){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","0");
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyGreenCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","绿色").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyBlueCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","蓝色").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyRedCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","红色").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyYellowCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","黄色").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyGreyCount(String academy) {
        QueryWrapper<StudentPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("health", "灰色").eq("academy", academy);
        Long count = studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyYesCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","1").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
    public Long academyNoCount(String academy){
        QueryWrapper<StudentPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","0").eq("academy",academy);
        Long count= studentDao.selectCount(wrapper);
        return count;
    }
}
