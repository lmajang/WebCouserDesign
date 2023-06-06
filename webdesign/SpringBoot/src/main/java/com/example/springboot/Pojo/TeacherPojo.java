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
@TableName(value="teacher")
public class TeacherPojo {
    @TableId(value = "Tno",type = IdType.ASSIGN_ID)
    private String id;
    @TableField("Tname")
    private String name;
    @TableField("Tidcard")
    private  String identity;
    @TableField("academy")
    private  String college;
    @TableField("role")
    private  String role;
    @TableField("health")
    private String health;
    @TableField("daily")
    private boolean daily;
    public String getPassword(){return this.identity.substring(this.identity.length()-8);}
}
