package com.springboot.upload.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 上传文件控制器
 * 直接上传到服务器
 */
@Controller
public class UploadController {
    //制定一个临时路径作为上传目录
    //  private  static  String UPload_FOLDER ="E/temp/";

    //遇到http://Localhost:8080.则跳转到upload.html页面
    @GetMapping("/")
    public  String index(){
        return  "/upload";
    }
    @PostMapping("/upload")
    public String fileUPload(@RequestParam("file")MultipartFile srcFile, RedirectAttributes redirectAttributes){
        //前端没有选择文件，srcFile为空
        if(srcFile.isEmpty()){
            redirectAttributes.addFlashAttribute("message","请选择一个文件");
            return  "redirect:upload_status";
        }
        try{
            //构建上传目标路径,找到了项目的target目录
            File descFile=new File(ResourceUtils.getURL("classpath:").getPath());
            if(descFile.exists()){
                descFile=new File("");
            }
            //输出目标文件的绝对路径
            System.out.println("file path:"+descFile.getAbsolutePath());
            //拼接static目录
            File upload=new File(descFile.getAbsolutePath(),"static/");
            //若目标文件文件夹不存在，则创建一个
            if(!upload.exists()){
                upload.mkdirs();
            }
            System.out.println("完整的上传路径:"+upload.getAbsolutePath()+"/"+srcFile.getOriginalFilename());
            //根据srcFile的大小，准备一个字节数组
            byte[] bytes=srcFile.getBytes();
            Path path=Paths.get(upload.getAbsolutePath()+"/"+srcFile.getOriginalFilename());
            // 拼接上传路径
            //  Path path= Paths.get(UPload_FOLDER +srcFile.getOriginalFilename());
            //最重要的一步，开始将源文件写入目标地址!!!
            Files.write(path,bytes);
            //将文件上传成功的信息写入message
            redirectAttributes.addFlashAttribute("message","文件上传成功"+srcFile.getOriginalFilename());
        }catch (IOException e){
            e.printStackTrace();
        }
        //选择了文件，开始进行上传操作
        return "upload_status";
    }
    //匹配 upload_status页面
    @GetMapping("/upload_status")
    public  String uploadStatusPage(){
        return  "upload_status";
    }
}
