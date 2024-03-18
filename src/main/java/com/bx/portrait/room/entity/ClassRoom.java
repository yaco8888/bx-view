package com.bx.portrait.room.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程视频(任务)层
 */
@Data
@TableName("/tb_course")
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom extends Model<ClassRoom> implements Serializable {

    /**
     * 课程ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程视频的地址
     */
    private String courseUrl;

    /**
     * 课程视频封面url
     */
    private String courseImgUrl;

    /**
     * 管理员ID(谁发的此课程视频)
     */
    private Integer sysId;

    /**
     * 创建时间
     */
    private String createTime;
}
