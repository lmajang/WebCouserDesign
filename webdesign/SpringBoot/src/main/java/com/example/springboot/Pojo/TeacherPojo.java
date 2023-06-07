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
    private String Tno;
    @TableField("Tname")
    private String Tname;
    @TableField("Tidcard")
    private  String Tidcard;
    @TableField("academy")
    private  String academy;
    @TableField("role")
    private  String role;
    @TableField("health")
    private String health;
    @TableField("daily")
    private boolean daily;
    public String getPassword(){return this.Tidcard.substring(this.Tidcard.length()-8);}
}
