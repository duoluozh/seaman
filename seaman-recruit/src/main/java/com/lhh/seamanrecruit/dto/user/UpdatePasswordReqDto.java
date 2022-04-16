package com.lhh.seamanrecruit.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * @Author: yslong
 * @Date: 2022/4/11 13:37
 * @Description: 修改密码入参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("修改密码入参")
public class UpdatePasswordReqDto {


    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 原密码
     */
    @ApiModelProperty(value = "原密码",required = true)
    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码",required = true)
    @NotBlank(message = "新密码不能为空")
    private String newPassword;


}
