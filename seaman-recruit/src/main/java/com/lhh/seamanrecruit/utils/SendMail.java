package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.dto.eamil.Email;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author zhh
 * @date 2022/4/10 22:17
 * @description 发送邮件
 */
public class SendMail {

    // 发送邮件
    public static void sendMails(Email email,String address){

        // 定义收件人
        InternetAddress to_address[] = new InternetAddress[1];
        try {
            to_address[0] = new InternetAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }

        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host","smtp.qq.com");
        properties.put("mail.smtp.auth", "true");


        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2354682205@qq.com","olxtvksfjklhebdb");
            }
        });


        // 定义头部字段及发邮件
        try {
            // 创建默认的MimeMessage对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人From 头部字段
            message.setFrom(new InternetAddress("2354682205@qq.com"));
            // 设置收件人To 头部字段
            message.addRecipients(Message.RecipientType.TO,to_address);
            // 设置Subject 头部字段
            message.setSubject(email.getSubject());
            // 设置消息体
            message.setText(email.getConetent());

            // 发送消息
            Transport.send(message);
            System.out.println("发送成功");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}