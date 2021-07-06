package com.zx.springboot.controller;

import com.zx.springboot.config.ConstantProperties;
import com.zx.springboot.uitl.core.cloud.AliyunOSSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
public class OSSUploadController {

    private final Logger logger = LoggerFactory.getLogger(OSSUploadController.class);

    @GetMapping(value = "/toUploadPage")
    public String toUploadPage() {
        return "upload";
    }

    /**
     * 上传文件------->>> oss
     *
     * @param file
     * @return
     */
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
                    System.out.println("文件保存路径为：" + uploadUrl);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    /**
     * 根据文件名删除文件
     *
     * @return
     */
    @GetMapping(value = "/deleteFile")
    @ResponseBody
    public String deleteFile() {
//        String ObjectKey = "blog/2019-06-05/a7743230864849f9873b34a90c834266-test.txt";
        String ObjectKey = "blog/2019-06-05/1d08316f79c04e86bbd88ab148629b1e-LogHistory.txt";
        AliyunOSSUtil.deleteFile(ObjectKey);
        return "删除成功";
    }

    /**
     * oss----->>>获取file 名称列表
     *
     * @return
     */
    @GetMapping(value = "/getObjectList")
    @ResponseBody
    public List<String> getFileList() {
        String bucketName = ConstantProperties.OSS_BUCKET_NAME1;
        List<String> fileList = AliyunOSSUtil.getObjectList(bucketName);
        return fileList;
    }
}
