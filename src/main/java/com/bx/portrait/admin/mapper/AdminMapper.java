package com.bx.portrait.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bx.portrait.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员mapper层
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
