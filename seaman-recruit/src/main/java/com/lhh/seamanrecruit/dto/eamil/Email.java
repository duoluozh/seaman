package com.lhh.seamanrecruit.dto.eamil;

/**
 * @author zhh
 * @date 2022/4/10 22:26
 * @description 邮件实体类
 */

public class Email {

    //收件人
    private String email;
    // 主题
    private String subject;
    // 内容
    private String conetent;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getConetent() {
        return conetent;
    }

    public void setConetent(String conetent) {
        this.conetent = conetent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
