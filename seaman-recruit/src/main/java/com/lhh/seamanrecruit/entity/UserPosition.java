package com.lhh.seamanrecruit.entity;

import java.time.LocalDateTime;

import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

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
public class UserPosition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */

	@Id
	@ApiModelProperty(value = "主键id")
	private Long id;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;

	/**
	 * 职位id
	 */
	@ApiModelProperty(value = "职位id")
	private Long positionId;

	/**
	 * 投递标识
	 */
	@ApiModelProperty(value = "投递标识(0-未投递,1-已投递,2-通过,3-拒绝)")
	private Integer deliveryFlag;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createdTime;

}
