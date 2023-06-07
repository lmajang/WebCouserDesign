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
    public String findmajor() {
        List<MajorPojo> list = majorService.findAllById();
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/academymajor", method = RequestMethod.POST)
    @ResponseBody
    public String findmajorByAcademy(HttpServletRequest request,@RequestBody Map map,
                                     @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String username=json.getString("usernameInput");
        TeacherPojo answer=teacherService.findTeacherById(username);
        String academy= answer.getAcademy();
        List<MajorPojo> list = majorService.findByAcademy(academy);
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/classinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findclass() {
        List<ClassPojo> list = classService.findAllById();
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/academyclass", method = RequestMethod.POST)
    @ResponseBody
    public String findclassByAcademy(HttpServletRequest request,@RequestBody Map map,
                                     @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String username=json.getString("usernameInput");
        TeacherPojo answer=teacherService.findTeacherById(username);
        String academy= answer.getAcademy();
        List<ClassPojo> list = classService.findByAcademy(academy);
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/studentinformation", method = RequestMethod.POST)
    @ResponseBody
    public String findstudent() {
        List<StudentPojo> list = studentService.findAllById();
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/academystudent", method = RequestMethod.POST)
    @ResponseBody
    public String findstudentByAcademy(HttpServletRequest request,@RequestBody Map map,
                                     @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String username=json.getString("usernameInput");
        TeacherPojo answer=teacherService.findTeacherById(username);
        String academy= answer.getAcademy();
        List<StudentPojo> list = studentService.findByAcademy(academy);
        String result = JSON.toJSONString(list);
        return result;
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
        String Tno= json.getString("TnoInput");
        String Tidcard=json.getString("TidcardInput");
        String Tname=json.getString("TnameInput");
        String academy=json.getString("academyInput");
        String role=json.getString("roleInput");
        String health="灰色";
        boolean daily=false;
        try {
            teacherService.addTeacher(Tname, Tidcard, Tno, academy, role, health, daily);
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
        String Sno= json.getString("SnoInput");
        String Sidcard=json.getString("SidcardInput");
        String major=json.getString("majorInput");
        String Sname=json.getString("SnameInput");
        String academy=json.getString("academyInput");
        String class1=json.getString("classInput");
        String health="灰色";
        boolean daily=false;
        try {
            studentService.addStudent(Sname, Sidcard, Sno, academy, major,class1,health,daily);
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
        String Tno= json.getString("TnoInput");
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
        String Sno = json.getString("SnoInput");
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

    @RequestMapping(value = "/yuanjijichang", method = RequestMethod.POST)
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
        String Sno = json.getString("SnoInput");
        String academy=json.getString("academyInput");
        String major=json.getString("majorInput");
        String class1=json.getString("classInput");
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
        String Tno = json.getString("TnoInput");
        String academy=json.getString("academyInput");
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

