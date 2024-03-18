package com.bx.portrait.room.service;

import com.bx.portrait.room.mapper.ClassRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 课程视频接口实现层
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomMapper classRoomMapper;

}
