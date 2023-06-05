package com.example.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.entity.UserAccount;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
@CrossOrigin
public class LoginController {
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestBody Map map, HttpSession session, @RequestParam Map<String, String> parameter){
       JSONObject json = new JSONObject(map);
        String username= json.getString("AccountInput");
        String password=json.getString("PasswordInput");
        try{
        UserAccount user = new UserAccount(username,password);
        if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")) {
            parameter.put("message", "success");
            parameter.put("status", "100");
            session.setAttribute("user",user);
        }
        else{
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
