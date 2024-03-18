package com.bx.portrait.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 管理员实体类
 */
@Data
@TableName("sys_admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Model<Admin> implements Serializable  {

    /**
     * 主建
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 管理面账号
     */
    private String adminUser;

    /**
     * 管理员密码
     */
    private String adminPassword;


    /**
     * 创建时间
     */
    private String createTime;

}
