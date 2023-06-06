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
@TableName(value="student")
public class StudentPojo {
    @TableId(value = "Sno",type = IdType.ASSIGN_ID)
    private String id;
    @TableField("Sname")
    private String name;
    @TableField("Sidcard")
    private  String identity;
    @TableField("academy")
    private  String college;
    @TableField("major")
    private  String major;
    @TableField("class")
    private  String class1;
    @TableField("health")
    private String health;
    @TableField("daily")
    private boolean daily;
    public String getPassword(){return this.identity.substring(this.identity.length()-8);}
}
