package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by BrickCat on 17/10/20.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class SettingController {

    @Value("${itbc.server.upload.dir}")
    private String upload;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/settings",method = RequestMethod.GET)
    public String setting(Map<String,Object> data){
        data.put(ITBC.TEMPLATE,"settings");
        return ITBC.SYSTEM_FRONT_TEMPLATE;
    }

    @RequestMapping(value = "/settings/avatar",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam(value = "avatar") MultipartFile file){
        if (file.isEmpty()) {
            return new Result(ITBC.ERROR_CODE,null,"文件不能为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = upload;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffix;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return new Result(ITBC.SUCCESS_CODE,null,"文件成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(ITBC.ERROR_CODE,null,"文件上传失败");
    }
}
