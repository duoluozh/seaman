package com.lhh.seamanrecruit.dto.position;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>招聘实体类</p>
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Data
@ApiModel("职位列表")
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@ApiModelProperty(value = "主键id")
	private Long id;

	/**
	 * 职位名称
	 */
	@ApiModelProperty(value = "职位名称")
	private String positionName;

	/**
	 * 招聘人数
	 */
	@ApiModelProperty(value = "招聘人数")
	private Integer positionNum;

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
	 * 船龄
	 */
	@ApiModelProperty(value = "船龄")
	private Integer shipAge;

	/**
	 * 具体航线
	 */
	@ApiModelProperty(value = "具体航线")
	private String specificRoute;

	/**
	 * 合同时长
	 */
	@ApiModelProperty(value = "合同时长")
	private String contractDuration;

	/**
	 * 上船地点
	 */
	@ApiModelProperty(value = "上船地点")
	private String boardingPlace;

	/**
	 * 月薪
	 */
	@ApiModelProperty(value = "月薪")
	private String monthlySalary;

	/**
	 * 学历
	 */
	@ApiModelProperty(value = "学历")
	private String education;

	/**
	 * 发布时间
	 */
	@ApiModelProperty(value = "发布时间")
	private LocalDateTime releaseTime;

	/**
	 * 职位编号
	 */
	@ApiModelProperty(value = "职位编号")
	private String positionCode;

	/**
	 * 公司名称
	 */
	@ApiModelProperty(value = "公司名称")
	private String companyName;

	/**
	 * 公司id
	 */
	@ApiModelProperty(value = "公司id")
	private Long companyId;

	/**
	 * 职位状态
	 */
	@ApiModelProperty(value = "职位状态(0-未发布，1-发布)")
	private String statusFlag;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;
}
