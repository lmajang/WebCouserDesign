package com.example.springboot;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.springboot.entity.UserAccount;
import com.example.springboot.Pojo.AdminPojo;
import com.example.springboot.Service.AdminServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    AdminServiceImpl adminService;
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestBody Map map, HttpSession session, @RequestParam Map<String, String> parameter){
        JSONObject json = new JSONObject(map);
        String username= json.getString("AccountInput");
        String password=json.getString("Password Input");
        try{
            boolean login=true;
            UserAccount user = new UserAccount(username,password);
            if(username.charAt(0)=='0'&&username.charAt(1)=='0') {
                if(password=="000"){
                    parameter.put("message","success");
                    parameter.put("status","100");
                    session.setAttribute("user",user);
                }
                else login=false;
            }
            else if(username.charAt(0)=='0'&&username.charAt(1)=='1'){
                AdminPojo answer=adminService.findAdminById(username);
                String password1=answer.getPassword();
                if(password1==password){
                    parameter.put("message","success");
                    parameter.put("status","200");
                    session.setAttribute("user",user);
                }
                else login=false;
            }
            else if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")) {
                parameter.put("message", "success");
                parameter.put("status", "300");
                session.setAttribute("user",user);
            }
            else if(login==false){
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
