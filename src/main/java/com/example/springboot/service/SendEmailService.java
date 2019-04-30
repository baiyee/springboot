package com.example.springboot.service;
import com.example.springboot.model.Mail;

/**
 * SendEmailService(描述其作用)
 * <p>
 * @author zsky 2019年4月30日16:37:21
 *
 * @version 1.0.0
 */
public interface SendEmailService
{
    /**
     * 发送邮件接口
     * @param mail
     * @return
     */
    boolean sendEmail(Mail mail);
}
