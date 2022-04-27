package com.lhh.seamanrecruit.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: yslong
 * @Date: 2022/4/25 13:34
 * @Description: 用户注册入参
 */
@Data
@ApiModel("用户注册入参")
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱", required = true)
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 用户类型(0-船员,1-企业用户,2-超管用户)
     */
    @ApiModelProperty(value = "用户类型(0-船员,1-企业用户,2-超管用户)", required = true)
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称", required = true)
    @NotNull(message = "企业名称不能为空")
    private String enterpriseName;

    /**
     * 社会信用码
     */
    @ApiModelProperty(value = "社会信用码", required = true)
    @NotNull(message = "社会信用码不能为空")
    private String socialCreditCode;

    /**
     * 法定代表人
     */
    @ApiModelProperty(value = "法定代表人",required = true)
    @NotNull(message = "法定代表人不能为空")
    private String legalRepresentative;

    /**
     * 注册资金
     */
    @ApiModelProperty(value = "注册资金",required = true)
    @NotNull(message = "注册资金不能为空")
    private Integer registeredCapital;

    /**
     * 成立时间
     */
    @ApiModelProperty(value = "成立时间",required = true)
    @NotNull(message = "成立时间不能为空")
    private LocalDateTime establishmentTime;

    /**
     * 公司性质
     */
    @ApiModelProperty(value = "公司性质",required = true)
    @NotNull(message = "公司性质不能为空")
    private String nature;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式",required = true)
    @NotNull(message = "联系方式不能为空")
    private String contact;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String synopsis;



}
