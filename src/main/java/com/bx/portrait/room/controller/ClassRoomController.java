package com.bx.portrait.room.controller;

import com.bx.portrait.room.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 课程视频控制层
 */
@RestController
@RequestMapping("/class")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("classroom/index");
    }
}
