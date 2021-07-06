package com.zx.springboot.controller;

import com.sargeraswang.util.ExcelUtil.ExcelLogs;
import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

@RestController
public class IndexController {

    @Value("${memberName}")
    private String memberName;

    @RequestMapping(value = "/")
    public String index() {
        return "hello world, i like coding";
    }

    @RequestMapping("/getMemberName")
    public String getMemberName(){
        return memberName;
    }


    public static void main(String[] args) {
        File f = new File("/Users/xinye/Desktop/电影压缩123.xlsx");
        try {

            InputStream inputStream = new FileInputStream(f);

            ExcelLogs logs = new ExcelLogs();
            Collection<Map> importExcel = ExcelUtil.importExcel(Map.class,inputStream,"yyyy/MM/dd HH:mm:ss",logs,0);

            for (Map m :importExcel) {
                System.out.println(m);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
