package com.example.springboot.controller;

import com.example.springboot.dto.response.WebApiResponse;
import com.example.springboot.model.Mail;
import com.example.springboot.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * SendMassageController(描述其作用)
 * <p>
 * @author zsky 2019年4月30日16:35:57
 * @version 1.0.0
 */
@RestController
@RequestMapping("/email")
public class SendMessageController
{
    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/send")
    public WebApiResponse<?> sendEmail(@RequestBody Mail mail){
        boolean result = sendEmailService.sendEmail(mail);
        return WebApiResponse.success(result);
    }


}
