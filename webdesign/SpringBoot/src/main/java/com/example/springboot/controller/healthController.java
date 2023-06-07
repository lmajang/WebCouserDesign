package com.example.springboot.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.springboot.Pojo.MajorPojo;
import com.example.springboot.Pojo.StudentPojo;
import com.example.springboot.Pojo.TeacherPojo;
import com.example.springboot.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class healthController {
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
    @RequestMapping(value = "/Teacherhealth", method = RequestMethod.POST)
    @ResponseBody
    public String health(HttpServletRequest request, @RequestBody String id,
                                     @RequestParam Map<String, String> parameter) {
        String username=id.substring(0,id.length()-1);
        TeacherPojo result=teacherService.findTeacherById(username);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/Teacherhealthget", method = RequestMethod.POST)
    @ResponseBody
    public String healthget(HttpServletRequest request, @RequestBody Map map,
                         @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Tno=json.getString("no");
        String goAffect= json.getString("goAffect");
        String goAbroad =json.getString("goAbroad");
        String isContact= json.getString("isContact");
        String isSicken =json.getString("isSicken");
        String isInjection= json.getString("isInjection");
        String isHealthy =json.getString("isHealthy");
        ArrayList list=json.getList("healthycondition");
        int num=list.size();
        int condition=0;
        boolean vaccinum=true;
        if(goAffect.equals("1")) condition=1;
        if(goAbroad.equals("1")) condition=1;
        if(num==1) condition=1;
        if(isContact.equals("1")) condition=2;
        if(isSicken.equals("1")) condition=2;
        if(isInjection.equals("0")) vaccinum=false;
        try {
            if (condition == 1) {
                teacherService.updatehealth(Tno, "黄色");
                parameter.put("helath", "yellow");
            } else if (condition == 2) {
                teacherService.updatehealth(Tno,"红色");
                parameter.put("health","red");
            } else {
                teacherService.updatedaily(Tno,true);
                if (vaccinum == true){
                    teacherService.updatehealth(Tno,"蓝色");
                    parameter.put("health","blue");
                }
                else{
                    teacherService.updatehealth(Tno,"绿色");
                    parameter.put("health","green");
                }
            }
        }
        catch (Exception e){
            parameter.put("health","grey");
        }
        return JSON.toJSONString(parameter);
    }

    @RequestMapping(value = "/Studenthealth", method = RequestMethod.POST)
    @ResponseBody
    public String health(HttpServletRequest request, @RequestBody String id,
                         @RequestParam Map<String, String> parameter) {
        String username=id.substring(0,id.length()-1);
        StudentPojo result=studentService.findStudentById(username);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/Studenthealthget", method = RequestMethod.POST)
    @ResponseBody
    public String healthget(HttpServletRequest request, @RequestBody Map map,
                            @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Sno=json.getString("no");
        String goAffect= json.getString("goAffect");
        String goAbroad =json.getString("goAbroad");
        String isContact= json.getString("isContact");
        String isSicken =json.getString("isSicken");
        String isInjection= json.getString("isInjection");
        String isHealthy =json.getString("isHealthy");
        ArrayList list=json.getList("healthycondition");
        int num=list.size();
        int condition=0;
        boolean vaccinum=true;
        if(goAffect.equals("1")) condition=1;
        if(goAbroad.equals("1")) condition=1;
        if(num==1) condition=1;
        if(isContact.equals("1")) condition=2;
        if(isSicken.equals("1")) condition=2;
        if(isInjection.equals("0")) vaccinum=false;
        try {
            if (condition == 1) {
                studentService.updatehealth(Sno, "黄色");
                parameter.put("helath", "yellow");
            } else if (condition == 2) {
                studentService.updatehealth(Sno,"红色");
                parameter.put("health","red");
            } else {
                studentService.updatedaily(Sno,true);
                if (vaccinum == true){
                    studentService.updatehealth(Sno,"蓝色");
                    parameter.put("health","blue");
                }
                else{
                    studentService.updatehealth(Sno,"绿色");
                    parameter.put("health","green");
                }
            }
        }
        catch (Exception e){
            parameter.put("health","grey");
        }
        return JSON.toJSONString(parameter);
    }
}
