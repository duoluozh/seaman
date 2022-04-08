package com.lhh.seamanrecruit.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>用户实体类</p>
 * @author yslong
 * @date 2022-04-08 10:50:08
 */
@Data
@ApiModel("用户注册入参")
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名",required = true)
	@NotBlank(message = "用户名不能为空")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码",required = true)
	@NotBlank(message = "密码不能为空")
	private String password;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱",required = true)
	@NotBlank(message = "邮箱不能为空")
	private String email;

	/**
	 * 用户类型(0-船员,1-企业用户,2-超管用户)
	 */
	@ApiModelProperty("用户类型(0-船员,1-企业用户,2-超管用户)")
	@NotNull(message = "用户类型不能为空")
	private Integer userType;

}
