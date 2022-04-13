package com.lhh.seamanrecruit.dto.eamil;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhh
 * @date 2022/4/10 22:26
 * @description 邮件实体类
 */
@Data
@ApiModel("邮件实体类")
@AllArgsConstructor
@NoArgsConstructor
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
