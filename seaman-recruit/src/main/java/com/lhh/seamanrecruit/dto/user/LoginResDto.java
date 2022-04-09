package com.lhh.seamanrecruit.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Author: yslong
 * @Date: 2022/4/9 11:16
 * @Description: 用户登录出参
 */
@Data
@ApiModel("用户登录入参")
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */

    @Id
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    private String email;

    /**
     * 用户类型(0-船员,1-企业用户,2-超管用户)
     */
    @ApiModelProperty(value = "用户类型(0-船员,1-企业用户,2-超管用户)")
    private Integer userType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updatedTime;
}
