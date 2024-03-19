package com.bx.portrait.admin.controller;

import com.bx.portrait.admin.service.AdminService;
import com.bx.portrait.room.entity.ClassRoom;
import com.bx.portrait.utils.UploadUtils;
import com.bx.portrait.utils.result.ResultMsg;
import com.bx.portrait.utils.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员控制层
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到管理页面
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("system/index");
    }


    @GetMapping("/course")
    public ModelAndView course() {
        return new ModelAndView("system/course/index");
    }

    /**
     * 查询所有的课程
     */
    @RequestMapping("/list")
    public ResultMsg list() {
        return ResultUtils.SUCCESS(new ClassRoom().selectAll());
    }

    /**
     * 发布任务
     * @return
     */
    @PostMapping("/add")
    public ResultMsg add(ClassRoom classRoom) {
        if (classRoom == null) {
            return ResultUtils.ERROR("请完善信息");
        }
        if ("".equals(classRoom.getCourseName()) || null == classRoom.getCourseName()) {
            return ResultUtils.ERROR("请输入课程名称");
        }
        if ("".equals(classRoom.getCourseUrl()) || null == classRoom.getCourseUrl()) {
            return ResultUtils.ERROR("请上传视频");
        }
        if ("".equals(classRoom.getCourseImgUrl()) || null == classRoom.getCourseImgUrl()) {
            return ResultUtils.ERROR("请上传封面");
        }
        boolean insert = classRoom.insert();
        if (!insert) return ResultUtils.ERROR("发布失败");
        return ResultUtils.SUCCESS();
    }

    /**
     * 删除发布的任务
     */
    @PostMapping("/delete/{id}")
    public ResultMsg deleteById(@PathVariable Integer id) {
        boolean b = new ClassRoom().deleteById(id);
        if (!b) return ResultUtils.ERROR();
        return  ResultUtils.SUCCESS();
    }

    /**
     * 上面文件返回一个地址
     */
    @PostMapping("/uplaod")
    public ResultMsg upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return ResultUtils.ERROR("请选择文件");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀名
        String fileExtension = "";
        if (fileName != null && fileName.contains(".")) {
            fileExtension = fileName.substring(fileName.lastIndexOf("."));
        }
        // 生成新的文件名称
        String toFileName = UploadUtils.getUUID() + fileExtension;
        // 开始上传文件, 并返回访问地址
        String lastPath = UploadUtils.uploadFile(file.getBytes(), uploadPath, toFileName);
        // 将地址返回给前端
        return ResultUtils.SUCCESS(lastPath);
    }
}
