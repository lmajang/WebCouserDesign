package com.example.springboot.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.springboot.Pojo.StudentPojo;
import com.example.springboot.Pojo.TeacherPojo;
import com.example.springboot.Service.StudentServiceImpl;
import com.example.springboot.Service.TeacherServiceImpl;
import com.example.springboot.entity.UserAccount;
import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Service.AdminServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;



@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, @RequestBody Map map,
                          @RequestParam Map<String, String> parameter,
                          HttpSession session){
        JSONObject json = new JSONObject(map);
        String username= json.getString("AccountInput");
        String password=json.getString("PasswordInput");
        try{
            boolean login=true;
            UserAccount user = new UserAccount(username,password);
            if(username.charAt(0)=='0'&&username.charAt(1)=='0') {
                if(password.equals("000")){
                    parameter.put("message","success");
                    parameter.put("status","100");
                    session.setAttribute("user",user);
                }
                else login=false;
            }
            else if(username.charAt(0)=='0'&&username.charAt(1)=='1'){
                AdminPojo answer=adminService.findAdminById(username);
                String password1=answer.getPassword();
                if(password1.equals(password)){
                    parameter.put("message","success");
                    parameter.put("status","200");
                    session.setAttribute("user",user);
                }
                else login=false;
            }
            else if(username.charAt(0)=='0'&&username.charAt(1)=='2'){
                AdminPojo answer=adminService.findAdminById(username);
                String password1=answer.getPassword();
                if(password1.equals(password)) {
                    parameter.put("message", "success");
                    parameter.put("status", "300");
                    session.setAttribute("user", user);
                }
                else login=false;
            }
            else if(username.charAt(0)=='0'&&username.charAt(1)=='3'){
                TeacherPojo answer=teacherService.findTeacherById(username);
                String password1=answer.getPassword();
                if(password1.equals(password)){
                    parameter.put("message", "success");
                    parameter.put("status", "400");
                    session.setAttribute("user", user);
                }
                else login=false;
            }
            else if(username.charAt(0)=='0'&&username.charAt(1)=='4'){
                StudentPojo answer=studentService.findStudentById(username);
                String password1=answer.getPassword();
                if(password1.equals(password)){
                    parameter.put("message", "success");
                    parameter.put("status", "500");
                    session.setAttribute("user", user);
                }
                else login=false;
        }
            if(login==false){
                parameter.put("message", "fail");
                parameter.put("status", "1");
            }
        }
        catch (Exception e){
            parameter.put("message", "fail");
            parameter.put("status", "0");
        }
        return JSON.toJSONString(parameter);
    }

}
