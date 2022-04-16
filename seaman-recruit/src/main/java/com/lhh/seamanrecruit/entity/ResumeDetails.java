package com.lhh.seamanrecruit.entity;


import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

/**
 * <p>简历明细实体类</p>
 * @author yslong
 * @date 2022-04-12 14:10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("简历明细")
@TableName(value = "resume_details")
public class ResumeDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */

	@Id
	@ApiModelProperty(value = "主键id")
	private Long id;

	/**
	 * 起始-结束
	 */
	@ApiModelProperty(value = "起始-结束")
	private String startEnd;

	/**
	 * 担任职务
	 */
	@ApiModelProperty(value = "担任职务")
	private String holdPosition;

	/**
	 * 船名
	 */
	@ApiModelProperty(value = "船名")
	private String shipName;

	/**
	 * 船舶类型
	 */
	@ApiModelProperty(value = "船舶类型")
	private String shipType;

	/**
	 * 总吨/马力
	 */
	@ApiModelProperty(value = "总吨/马力")
	private String grossTon;

	/**
	 * 航线
	 */
	@ApiModelProperty(value = "航线")
	private String route;

	/**
	 * 所在公司
	 */
	@ApiModelProperty(value = "所在公司")
	private String company;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;

}
