package com.lhh.seamanrecruit.entity;

import java.time.LocalDateTime;

import com.lhh.seamanrecruit.config.Table;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

/**
 * <p>用户职员表实体类</p>
 * @author zhh
 * @date 2022-04-15 22:13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户职员表")
@TableName(value = "user_position")
@Table(tableName = "user_position",keyFields = "id")
public class UserPosition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */

	@Id
	@ApiModelProperty(value = "主键id")
	@Column(name = "id")
	private Long id;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 职位id
	 */
	@ApiModelProperty(value = "职位id")
	@Column(name = "position_id")
	private Long positionId;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@Column(name = "created_time")
	private LocalDateTime createdTime;

	/**
	 * 投递处理标记(0-投递未处理,1-拒绝,2-通过)
	 */
	@ApiModelProperty(value = "投递处理标记(0-投递未处理,1-拒绝,2-通过)")
	@Column(name = "delivery_flag")
	private String deliveryFlag;

}
