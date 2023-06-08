package com.example.springboot.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.Pojo.*;
import com.example.springboot.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    ClassServiceImpl classService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    CollegeServiceImpl collegeService;
    @Autowired
    MajorServiceImpl majorService;
    @Autowired
    AdminServiceImpl adminService;

    @RequestMapping(value = "/academyinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findacademy() {
        List<CollegePojo> list = collegeService.findAllById();
        String result = JSON.toJSONString(list);
        return result;
    }



    @RequestMapping(value = "/majorinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findmajor(HttpServletRequest request,@RequestBody String id,
                                     @RequestParam Map<String, String> parameter) {
        String username = id.substring(0, id.length() - 1);
        String academy = teacherService.findTeacherById(username).getAcademy();
        if(username.charAt(1)=='2') {
            List<MajorPojo> list = majorService.findByAcademy(academy);
            String result = JSON.toJSONString(list);
            return result;
        }
        else {
            List<MajorPojo> list = majorService.findAllById();
            String result = JSON.toJSONString(list);
            return result;
        }
    }

    @RequestMapping(value = "/classinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findclass(HttpServletRequest request,@RequestBody String id,
                                     @RequestParam Map<String, String> parameter) {
        String username = id.substring(0, id.length() - 1);
        String academy = teacherService.findTeacherById(username).getAcademy();
        if(username.charAt(1)=='2') {
            List<ClassPojo> list = classService.findByAcademy(academy);
            String result = JSON.toJSONString(list);
            return result;
        }
        else {
            List<ClassPojo> list = classService.findAllById();
            String result = JSON.toJSONString(list);
            return result;
        }
    }



    @RequestMapping(value = "/studentinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findstudent(HttpServletRequest request,@RequestBody String id,
                                     @RequestParam Map<String, String> parameter) {
        String username = id.substring(0, id.length() - 1);
        String academy = teacherService.findTeacherById(username).getAcademy();
        if(username.charAt(1)=='2') {
            List<StudentPojo> list = studentService.findByAcademy(academy);
            String result = JSON.toJSONString(list);
            return result;
        }
        else {
            List<StudentPojo> list = studentService.findAllById();
            String result = JSON.toJSONString(list);
            return result;
        }
    }

    @RequestMapping(value = "/teacherinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findteacher() {
        List<TeacherPojo> list = teacherService.findAllById();
        String result = JSON.toJSONString(list);
        return result;
    }
    @RequestMapping(value = "/teacheradd", method = RequestMethod.POST)
    @ResponseBody
    public String addteacher(HttpServletRequest request,@RequestBody Map map,
                             @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Tno= json.getString("tno");
        String Tidcard=json.getString("tidcard");
        String Tname=json.getString("tname");
        String academy=json.getString("academy");
        String role=json.getString("role");
        String health="灰色";
        int daily=0;
        int daycount=0;
        try {
            teacherService.addTeacher(Tno,Tname  ,Tidcard, academy, role, health, daily,daycount);
            parameter.put("message", "success");
            parameter.put("status", "200");
        }catch (Exception e){
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/studentadd", method = RequestMethod.POST)
    @ResponseBody
    public String addstudent(HttpServletRequest request,@RequestBody Map map,
                             @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Sno= json.getString("sno");
        String Sidcard=json.getString("sidcard");
        String major=json.getString("major");
        String Sname=json.getString("sname");
        String academy=json.getString("academy");
        String class1=json.getString("class");
        String health="灰色";
        int daily=0;
        int daycount=0;
        try {
            studentService.addStudent(Sno,Sname, Sidcard, academy, major,class1,health,daily,daycount);
            parameter.put("message", "success");
            parameter.put("status", "200");
        }catch (Exception e){
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/teacherdel", method = RequestMethod.POST)
    @ResponseBody
    public String delteacher(HttpServletRequest request,@RequestBody Map map,
                             @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Tno= json.getString("tno");
        System.out.println(Tno);
        try {
            teacherService.delTeacher(Tno);
            parameter.put("message", "success");
            parameter.put("status", "200");
        }catch (Exception e){
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/studentdel", method = RequestMethod.POST)
    @ResponseBody
    public String delstudent(HttpServletRequest request,@RequestBody Map map,
                             @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Sno = json.getString("sno");
        try {
            studentService.delStudent(Sno);
            parameter.put("message", "success");
            parameter.put("status", "200");
        } catch (Exception e) {
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }
    @RequestMapping(value = "/admininformation", method = RequestMethod.POST)
    @ResponseBody
    public String admininformation (HttpServletRequest request, @RequestBody String id,
                                @RequestParam Map < String, String > parameter){
        String username = id.substring(0, id.length() - 1);

            if (username.charAt(1) == '1'){
                List<AdminPojo> result=adminService.findacademy();
                return JSON.toJSONString(result);
            }
           else {
               List<AdminPojo> result=adminService.findAll();
               return JSON.toJSONString(result);
            }
    }
        @RequestMapping(value = "/xiaojichange", method = RequestMethod.POST)
        @ResponseBody
        public String xiaojichange (HttpServletRequest request, @RequestBody Map map,
                @RequestParam Map < String, String > parameter){
            JSONObject json = new JSONObject(map);
            String password = json.getString("passwordInput");
            try {
                adminService.xiaojichange(password);
                parameter.put("message", "success");
                parameter.put("status", "200");
            } catch (Exception e) {
                parameter.put("message", "fail");
                parameter.put("status", "0");
            }
            return JSON.toJSONString(parameter);
        }

    @RequestMapping(value = "/yuanjijichange", method = RequestMethod.POST)
    @ResponseBody
    public String yuanjichange (HttpServletRequest request, @RequestBody Map map,
                              @RequestParam Map < String, String > parameter){
        JSONObject json = new JSONObject(map);
        String password = json.getString("passwordInput");
        try {
            adminService.yuanjichange(password);
            parameter.put("message", "success");
            parameter.put("status", "200");
        } catch (Exception e) {
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/studentupdate", method = RequestMethod.POST)
    @ResponseBody
    public String Studentchange (HttpServletRequest request, @RequestBody Map map,
                                @RequestParam Map < String, String > parameter){
        JSONObject json = new JSONObject(map);
        String Sno = json.getString("sno");
        String academy=json.getString("academy");
        String major=json.getString("major");
        String class1=json.getString("class");
        try {
            studentService.updateStudent(Sno,academy,major,class1);
            parameter.put("message", "success");
            parameter.put("status", "200");
        } catch (Exception e) {
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/teacherupdate", method = RequestMethod.POST)
    @ResponseBody
    public String Teacherchange (HttpServletRequest request, @RequestBody Map map,
                                 @RequestParam Map < String, String > parameter){
        JSONObject json = new JSONObject(map);
        String Tno = json.getString("tno");
        String academy=json.getString("academy");
        try {
            teacherService.updateTeacher(Tno,academy);
            parameter.put("message", "success");
            parameter.put("status", "200");
        } catch (Exception e) {
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }
}

