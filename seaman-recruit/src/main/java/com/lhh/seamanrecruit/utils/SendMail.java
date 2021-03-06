package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dto.eamil.Email;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author zhh
 * @date 2022/4/10 22:17
 * @description 发送邮件
 */
@Slf4j
public class SendMail {

    /**
     * 发件人
     */
    public static final String EMAIL_SENDER = "hyzpxt<2354682205@qq.com>";
    /**
     * 发件主机
     */
    public static final String SENDING_HOST = "smtp.qq.com";
    /**
     * 发件人账号
     */
    public static final String USERNAME = "2354682205@qq.com";
    /**
     * 发件人密码
     */
    public static final String PASSWORD = "olxtvksfjklhebdb";

    /**
     *
     * @param email 邮箱实体
     * @param address 收件人
     * @return 发送结果
     */
    public static String sendMails(Email email,String address){

        // 定义收件人
        InternetAddress[] toAddress = new InternetAddress[1];
        try {
            toAddress[0] = new InternetAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }

        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host",SENDING_HOST);
        properties.put("mail.smtp.auth", "true");


        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME,PASSWORD);
            }
        });

        // 定义头部字段及发邮件
        try {
            // 创建默认的MimeMessage对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人From 头部字段
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            // 设置收件人To 头部字段
            message.addRecipients(Message.RecipientType.TO,toAddress);
            // 设置Subject 头部字段
            message.setSubject(email.getSubject());
            // 设置消息体
            message.setText(email.getContent());
            // 发送邮件
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            log.info("邮件发送异常信息:{}",e.getMessage());
            return Constant.EMAIL_ERROR;
        }
        return Constant.EMAIL_SUCCESS;
    }

}