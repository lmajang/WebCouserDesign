package com.example.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    public Long GreenCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","绿色");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long RedCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","红色");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long BlueCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","蓝色");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long YellowCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","黄色");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long GreyCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","灰色");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long YesCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","1");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long NoCount(){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","0");
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyGreenCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","绿色").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyBlueCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","蓝色").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyRedCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","红色").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyYellowCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","黄色").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyGreyCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("health","灰色").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyYesCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","1").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
    public Long academyNoCount(String academy){
        QueryWrapper<TeacherPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("daily","0").eq("academy",academy);
        Long count= teacherDao.selectCount(wrapper);
        return count;
    }
}
