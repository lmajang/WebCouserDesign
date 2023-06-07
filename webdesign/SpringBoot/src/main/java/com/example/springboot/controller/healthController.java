package com.example.springboot.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
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
    public String teacherhealth(HttpServletRequest request, @RequestBody String id,
                                     @RequestParam Map<String, String> parameter) {
        String username=id.substring(0,id.length()-1);
        TeacherPojo result=teacherService.findTeacherById(username);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/Teacherhealthget", method = RequestMethod.POST)
    @ResponseBody
    public String teacherhealthget(HttpServletRequest request, @RequestBody Map map,
                         @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Tno=json.getString("no");
        String goAffect= json.getString("goAffect");
        String goAbroad =json.getString("goAbroad");
        String isContact= json.getString("isContact");
        String isSicken =json.getString("isSicken");
        String isInjection= json.getString("isInjection");
        String isHealthy =json.getString("isHealthy");
        JSONArray list=json.getJSONArray("healthyCondition");
        int num=list.size();
        int condition=0;
        boolean vaccinum=true;
        if(goAffect.equals("1")) condition=1;
        if(goAbroad.equals("1")) condition=1;
        if(num==1) condition=1;
        if(isContact.equals("1")) condition=2;
        if(isSicken.equals("1")) condition=2;
        if(num>=2) condition=2;
        if(isInjection.equals("0")) vaccinum=false;
        try {
            if (condition == 1) {
                teacherService.updatedaycount(Tno, 7);
                teacherService.updatehealth(Tno, "黄色");
                parameter.put("health", "yellow");
            } else if (condition == 2) {
                teacherService.updatedaycount(Tno, 14);
                teacherService.updatehealth(Tno, "红色");
                parameter.put("health", "red");
            } else {
                teacherService.updatedaily(Tno, 1);
                TeacherPojo result = teacherService.findTeacherById(Tno);
                int count = result.getDaycount();
                if (count == 0 || count == 1) {
                    teacherService.updatedaycount(Tno, 0);
                    if (vaccinum == true) {
                        teacherService.updatehealth(Tno, "蓝色");
                        parameter.put("health", "blue");
                    } else {
                        teacherService.updatehealth(Tno, "绿色");
                        parameter.put("health", "green");
                    }
                } else {
                    count = count - 1;
                    if (count == 7) {
                        teacherService.updatehealth(Tno, "黄色");
                        parameter.put("health", "yellow");
                    }
                    teacherService.updatedaycount(Tno, count);
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
    public String studenthealth(HttpServletRequest request, @RequestBody String id,
                         @RequestParam Map<String, String> parameter) {
        String username=id.substring(0,id.length()-1);
        StudentPojo result=studentService.findStudentById(username);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/Studenthealthget", method = RequestMethod.POST)
    @ResponseBody
    public String studenthealthget(HttpServletRequest request, @RequestBody Map map,
                            @RequestParam Map<String, String> parameter) {
        JSONObject json = new JSONObject(map);
        String Sno=json.getString("no");
        String goAffect= json.getString("goAffect");
        String goAbroad =json.getString("goAbroad");
        String isContact= json.getString("isContact");
        String isSicken =json.getString("isSicken");
        String isInjection= json.getString("isInjection");
        String isHealthy =json.getString("isHealthy");
        JSONArray list=json.getJSONArray("healthyCondition");
        int num=list.size();
        int condition=0;
        boolean vaccinum=true;
        if(goAffect.equals("1")) condition=1;
        if(goAbroad.equals("1")) condition=1;
        if(num==1) condition=1;
        if(isContact.equals("1")) condition=2;
        if(isSicken.equals("1")) condition=2;
        if(num>=2) condition=2;
        if(isInjection.equals("0")) vaccinum=false;
        try {
            if (condition == 1) {
                studentService.updatedaycount(Sno, 7);
                studentService.updatehealth(Sno, "黄色");
                parameter.put("health", "yellow");
            } else if (condition == 2) {
                studentService.updatedaycount(Sno,14);
                studentService.updatehealth(Sno,"红色");
                parameter.put("health","red");
            } else {
                studentService.updatedaily(Sno,1);
                StudentPojo result = studentService.findStudentById(Sno);
                int count = result.getDaycount();
                if(count==0||count==1) {
                     studentService.updatedaycount(Sno,0);
                    if (vaccinum == true) {
                        studentService.updatehealth(Sno, "蓝色");
                        parameter.put("health", "blue");
                    } else {
                        studentService.updatehealth(Sno, "绿色");
                        parameter.put("health", "green");
                    }
                }
                else{
                    count = count - 1;
                    if (count == 7) {
                        studentService.updatehealth(Sno, "黄色");
                        parameter.put("health", "yellow");
                    }
                    studentService.updatedaycount(Sno, count);
                }
            }
        }
        catch (Exception e){
            parameter.put("health","grey");
        }
        return JSON.toJSONString(parameter);
    }
}
