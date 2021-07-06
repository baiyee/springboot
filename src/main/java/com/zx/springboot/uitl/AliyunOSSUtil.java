package com.zx.springboot.uitl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.zx.springboot.config.ConstantProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author xinye
 * @version 1.0.0
 * <p>
 * ----------------------------------------------------------------------------
 * modifyer    modifyTime                 comment
 * ----------------------------------------------------------------------------
 * </p>
 * @ClassName: AliyunOSSUtil
 * @Description: aliyunOSSUtil
 * @date 2019-06-05 12:29
 */
public class AliyunOSSUtil {

    private static final Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * oss 文件上传
     *
     * @param file
     * @return
     */
    public static String upload(File file) {
        logger.info("==========》OSS文件上传开始：" + file.getName());
        String endpoint = ConstantProperties.OSS_END_POINT;
        String accessKeyId = ConstantProperties.OSS_ACCESS_KEY_ID;
        String accessKeySecret = ConstantProperties.OSS_ACCESS_KEY_SECRET;
        String bucketName = ConstantProperties.OSS_BUCKET_NAME1;
        String fileHost = ConstantProperties.OSS_FILE_HOST;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        logger.info("文件创建时间为：" + dateStr);

        if (null == file) {
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            logger.info("上传" + file.getName() + "文件路径为：" + fileUrl);
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里设置公开读
            if (null != result) {
                logger.info("=========》OSS文件上传成功,OSS地址：" + fileUrl);
                return fileUrl;
            } else {
                logger.error("文件上传失败,请重试。");
            }

        } catch (OSSException oe) {
            logger.error(oe.getMessage());
        } catch (ClientException ce) {
            logger.error(ce.getMessage());
        } finally {
            //关闭 oss
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * oss 文件删除
     *
     * @param fileKey
     * @return
     */
    public static String deleteFile(String fileKey) {
        logger.info("===========》OSS文件删除开始");
        String endpoint = ConstantProperties.OSS_END_POINT;
        String accessKeyId = ConstantProperties.OSS_ACCESS_KEY_ID;
        String accessKeySecret = ConstantProperties.OSS_ACCESS_KEY_SECRET;
        String bucketName = ConstantProperties.OSS_BUCKET_NAME1;
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            if (!ossClient.doesBucketExist(bucketName)) {
                logger.info("==============》您的Bucket不存在");
                return "您的bucket不存在";
            } else {
                logger.info("==============》开始删除 Object");
                ossClient.deleteObject(bucketName, fileKey);
                logger.info("==============》Object 删除成功：" + fileKey);
                return "==============》Object 删除成功：" + fileKey;
            }
        } catch (Exception ex) {
            logger.error("删除" + fileKey + "失败", ex);
            return "删除" + fileKey + "失败";
        }
    }


    /**
     * 查询文件名列表
     *
     * @param bucketName
     * @return
     */
    public static List<String> getObjectList(String bucketName) {
        List<String> listRe = new ArrayList<>();
        String endpoint = ConstantProperties.OSS_END_POINT;
        String accessKeyId = ConstantProperties.OSS_ACCESS_KEY_ID;
        String accessKeySecret = ConstantProperties.OSS_ACCESS_KEY_SECRET;
        try {
            logger.info("==============》开始查询文件名列表");
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
            //列出blog目录下今天所有文件
            listObjectsRequest.setPrefix("blog/" + format.format(new Date()) + "/");
            ObjectListing list = ossClient.listObjects(listObjectsRequest);
            for (OSSObjectSummary ossObjectSummary : list.getObjectSummaries()) {
                listRe.add(ossObjectSummary.getKey());
            }
            logger.info("list =" + listRe);
            return listRe;
        } catch (Exception ex) {
            logger.info("==============》查询列表失败", ex);
            return new ArrayList<>();
        }
    }
}
