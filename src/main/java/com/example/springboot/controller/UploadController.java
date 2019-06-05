package com.example.springboot.controller;

import com.example.springboot.uitl.AliyunOSSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xinye
 * @version 1.0.0
 * <p>
 * ----------------------------------------------------------------------------
 * modifyer    modifyTime                 comment
 * ----------------------------------------------------------------------------
 * </p>
 * @ClassName: UploadController
 * @Description: oss 文件上传
 * @date 2019-06-05 14:28
 */
@Controller
@RequestMapping("upload")
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @GetMapping(value = "/toUploadPage")
    public String toUploadPage() {
        return "upload";
    }

    @PostMapping(value = "/ossUploadFile")
    public String ossUploadFile(MultipartFile file) {
        logger.info("==================》文件正在上传");
        try {
            if (null != file) {
                String fileName = file.getOriginalFilename();
                if (!"".equals(fileName.trim())) {
                    File newFile = new File(fileName);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String uploadUrl = AliyunOSSUtil.upload(newFile);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
