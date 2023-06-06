package com.example.springboot.Pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="admin")
public class AdminPojo {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;
    @TableField("name")
    private String name;
    @TableField("password")
    private  String password;
    @TableField("role")
    private  String role;
    public String getPassword(){return this.password;}
}
