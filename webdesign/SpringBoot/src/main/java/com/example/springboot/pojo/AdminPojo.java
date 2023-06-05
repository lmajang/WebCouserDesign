package com.example.springboot.pojo;


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
    @TableId(value = "id",type = IdType.NONE)
    private String id;
    @TableField(value = "password")
    private  String password;

    public String getpassword(){return this.password;}
}
