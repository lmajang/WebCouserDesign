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
@TableName(value="class")
public class ClassPojo {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;
    @TableField("name")
    private String name;
    @TableField("major")
    private  String major;
    @TableField("academy")
    private  String academy;
}
