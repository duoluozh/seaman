package com.lhh.seamanrecruit.entity;

import java.time.LocalDateTime;

import com.lhh.seamanrecruit.config.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

/**
 * <p>用户实体类</p>
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
@Data
@ApiModel("用户")
@TableName(value = "user")
@AllArgsConstructor
@NoArgsConstructor
@Table(tableName = "user",keyFields = "id")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */

	@Id
	@ApiModelProperty(value = "主键ID")
	@Column(name = "id")
	private Long id;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	@Column(name = "user_name")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	@Column(name = "password")
	private String password;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱")
	@Column(name = "email")
	private String email;

	/**
	 * 用户类型(0-船员,1-企业用户,2-超管用户)
	 */
	@ApiModelProperty(value = "用户类型(0-船员,1-企业用户,2-超管用户)")
	@Column(name = "user_type")
	private Integer userType;

	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像")
	@Column(name = "head_portrait")
	private String headPortrait;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@Column(name = "created_time")
	private LocalDateTime createdTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

}
