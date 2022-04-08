package com.lhh.seamanrecruit.entity;

import java.time.LocalDateTime;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

/**
 * <p>用户实体类</p>
 * @author yslong
 * @date 2022-04-08 09:59:02
 */
@Data
@ApiModel("用户")
@TableName(value = "user")
public class User {
private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@Id
	private Long id;

	/**
	 * 用户名
	 */
	@ApiModelProperty("用户名")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty("电子邮箱")
	private String email;

	/**
	 * 用户类型(0-船员,1-企业用户,2-超管用户)
	 */
	@ApiModelProperty("用户类型(0-船员,1-企业用户,2-超管用户)")
	private Integer userType;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private LocalDateTime createdTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private LocalDateTime updatedTime;

}
