package com.example.springboot.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.springboot.Pojo.TeacherPojo;
import com.example.springboot.Service.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@CrossOrigin
public class StatisticController {
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



    @RequestMapping(value = "/healthstatistic", method = RequestMethod.POST)
    @ResponseBody
    public String healthstatistic(HttpServletRequest request, @RequestBody String id,
                                         @RequestParam Map<String, String> map) {
        String username=id.substring(0,id.length()-1);
        String academy=teacherService.findTeacherById(username).getAcademy();
        if(username.charAt(1)=='2') {
            Long green = studentService.academyGreenCount(academy) + teacherService.academyGreenCount(academy);
            Long blue = studentService.academyBlueCount(academy) + teacherService.academyBlueCount(academy);
            Long red = studentService.academyRedCount(academy) + teacherService.academyRedCount(academy);
            Long yellow = studentService.academyYellowCount(academy) + teacherService.academyYellowCount(academy);
            Long grey = studentService.academyGreyCount(academy) + teacherService.academyGreyCount(academy);
            map.clear();
            map.put("green", String.valueOf(green));
            map.put("blue", String.valueOf(blue));
            map.put("red", String.valueOf(red));
            map.put("yellow", String.valueOf(yellow));
            map.put("grey", String.valueOf(grey));
            return JSON.toJSONString(map);
        }
        else {
            Long green=studentService.GreenCount()+teacherService.GreenCount();
            Long blue=studentService.BlueCount()+teacherService.BlueCount();
            Long red=studentService.RedCount()+teacherService.RedCount();
            Long yellow=studentService.YellowCount()+teacherService.YellowCount();
            Long grey=studentService.GreyCount()+teacherService.GreyCount();
            map.clear();
            map.put("green",String.valueOf(green));
            map.put("blue",String.valueOf(blue));
            map.put("red",String.valueOf(red));
            map.put("yellow",String.valueOf(yellow));
            map.put("grey",String.valueOf(grey));
            return JSON.toJSONString(map);
        }
   }
    @RequestMapping(value = "/dailystatistic", method = RequestMethod.POST)
    @ResponseBody
    public String dailystatistic(HttpServletRequest request, @RequestBody String id,
                                         @RequestParam Map<String, String> map) {
            String username = id.substring(0, id.length() - 1);
            String academy = teacherService.findTeacherById(username).getAcademy();
            if(username.charAt(1)=='2') {
                Long yes = studentService.academyYesCount(academy) + teacherService.academyYesCount(academy);
                Long no = studentService.academyNoCount(academy) + teacherService.academyNoCount(academy);
                map.clear();
                map.put("yes", String.valueOf(yes));
                map.put("no", String.valueOf(no));
                return JSON.toJSONString(map);
            }
            else {
                Long yes=studentService.YesCount()+teacherService.YesCount();
                Long no=studentService.NoCount()+teacherService.NoCount();
                map.clear();
                map.put("yes",String.valueOf(yes));
                map.put("no",String.valueOf(no));
                return JSON.toJSONString(map);
            }
        }

}
