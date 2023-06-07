package com.example.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Dao.TeacherDao;
import com.example.springboot.Pojo.MajorPojo;
import com.example.springboot.Pojo.StudentPojo;
import com.example.springboot.Pojo.TeacherPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl {
    @Autowired
    TeacherDao teacherDao;

    public TeacherPojo findTeacherById(String id){return teacherDao.selectById(id);}

    public List<TeacherPojo> findAllById(){return teacherDao.selectList(new QueryWrapper<>());}

    public void addTeacher(String Tname,String Tidcard,String Tno,String academy,
                           String role,String health,boolean daily,int daycount){
        teacherDao.insert(new TeacherPojo(Tname,Tidcard,Tno,academy,role,health,daily,daycount));
    }
    public void delTeacher(String Tno){
        teacherDao.deleteById(Tno);
    }

    public void updateTeacher(String Tno,String academy){
        TeacherPojo teacherPojo=new TeacherPojo();
        teacherPojo.setAcademy(academy);
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Tno",Tno);
        teacherDao.update(teacherPojo,wrapper);
    }
    public void updatehealth(String Tno,String health){
        TeacherPojo teacherPojo=new TeacherPojo();
        teacherPojo.setHealth(health);
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Tno",Tno);
        teacherDao.update(teacherPojo,wrapper);
    }
    public void updatedaily(String Tno,boolean daily){
        TeacherPojo teacherPojo=new TeacherPojo();
        teacherPojo.setDaily(daily);
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Tno",Tno);
        teacherDao.update(teacherPojo,wrapper);
    }

    public void updatedaycount(String Tno,int daycount){
        TeacherPojo teacherPojo=new TeacherPojo();
        teacherPojo.setDaycount(daycount);
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("Tno",Tno);
        teacherDao.update(teacherPojo,wrapper);
    }
}
