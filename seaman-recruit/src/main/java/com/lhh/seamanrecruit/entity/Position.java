package com.lhh.seamanrecruit.entity;


import com.lhh.seamanrecruit.config.Table;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

/**
 * <p>职位实体类</p>
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("职位")
@TableName(value = "position")
@Table(tableName = "position",keyFields = "id")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */

	@Id
	@ApiModelProperty(value = "主键id")
	@Column(name = "id")
	private Long id;

	/**
	 * 职位名称
	 */
	@ApiModelProperty(value = "职位名称")
	@Column(name = "position_name")
	private String positionName;

	/**
	 * 招聘人数
	 */
	@ApiModelProperty(value = "招聘人数")
	@Column(name = "position_num")
	private Integer positionNum;

	/**
	 * 船舶类型
	 */
	@ApiModelProperty(value = "船舶类型")
	@Column(name = "ship_type")
	private String shipType;

	/**
	 * 总吨/马力
	 */
	@ApiModelProperty(value = "总吨/马力")
	@Column(name = "gross_ton")
	private String grossTon;

	/**
	 * 船龄
	 */
	@ApiModelProperty(value = "船龄")
	@Column(name = "ship_age")
	private Integer shipAge;

	/**
	 * 具体航线
	 */
	@ApiModelProperty(value = "具体航线")
	@Column(name = "specific_route")
	private String specificRoute;

	/**
	 * 合同时长
	 */
	@ApiModelProperty(value = "合同时长")
	@Column(name = "contract_duration")
	private String contractDuration;

	/**
	 * 上船地点
	 */
	@ApiModelProperty(value = "上船地点")
	@Column(name = "boarding_place")
	private String boardingPlace;

	/**
	 * 月薪
	 */
	@ApiModelProperty(value = "月薪")
	@Column(name = "monthly_salary")
	private String monthlySalary;

	/**
	 * 学历
	 */
	@ApiModelProperty(value = "学历")
	@Column(name = "education")
	private String education;

	/**
	 * 发布时间
	 */
	@ApiModelProperty(value = "发布时间")
	@Column(name = "release_time")
	private LocalDateTime releaseTime;

	/**
	 * 职位编号
	 */
	@ApiModelProperty(value = "职位编号")
	@Column(name = "position_code")
	private String positionCode;

	/**
	 * 公司名称
	 */
	@ApiModelProperty(value = "公司名称")
	@Column(name = "company_name")
	private String companyName;

	/**
	 * 公司id
	 */
	@ApiModelProperty(value = "公司id")
	@Column(name = "company_id")
	private Long companyId;

	/**
	 * 职位状态
	 */
	@ApiModelProperty(value = "职位状态(0-未发布，1-发布)")
	@Column(name = "status_flag")
	private String statusFlag;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@Column(name = "update_time")
	private LocalDateTime updateTime;


}
