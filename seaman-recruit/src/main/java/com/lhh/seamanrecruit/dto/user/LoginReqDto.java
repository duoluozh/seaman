package com.lhh.seamanrecruit.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>用户登录入参</p>
 * @author yslong
 * @date 2022-04-08 10:50:08
 */
@Data
@ApiModel("用户登录入参")
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名",required = true)
	private String userName;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱",required = true)
	private String email;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码",required = true)
	@NotBlank(message = "密码不能为空")
	private String password;


	/**
	 * 验证码
	 */
	@ApiModelProperty(value = "验证码",required = false)
	private String verificationCode;

}
