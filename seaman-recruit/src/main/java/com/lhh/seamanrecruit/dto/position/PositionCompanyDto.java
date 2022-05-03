package com.lhh.seamanrecruit.dto.position;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>招聘实体类</p>
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("招聘详情实体类")
@TableName(value = "positionCompanyDto")
public class PositionCompanyDto implements Serializable {

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
	 * 公司性质
	 */
	@ApiModelProperty(value = "公司性质")
	private String companyType;

	/**
	 * 成立年份
	 */
	@ApiModelProperty(value = "成立年份")
	private LocalDate year;

	/**
	 * 注册资金
	 */
	@ApiModelProperty(value = "注册资金")
	private Long capital;

	/**
	 * 员工人数
	 */
	@ApiModelProperty(value = "员工人数")
	private String employeesNumber;

	/**
	 * 公司网址
	 */
	@ApiModelProperty(value = "公司网址")
	private String website;

	/**
	 * 公司简介
	 */
	@ApiModelProperty(value = "公司简介")
	private String companyDesc;

	/**
	 * 联系人
	 */
	@ApiModelProperty(value = "联系人")
	private String contactsName;

	/**
	 * 固定电话
	 */
	@ApiModelProperty(value = "固定电话")
	private String phone;

	/**
	 * 传真
	 */
	@ApiModelProperty(value = "传真")
	private String fax;

	/**
	 * 联系手机
	 */
	@ApiModelProperty(value = "联系手机")
	private String contactsPhone;

	/**
	 * 地址
	 */
	@ApiModelProperty(value = "地址")
	private String address;

	/**
	 * 是否投递标记(0-未投递,1-已投递)
	 */
	@ApiModelProperty(value = "是否投递标记(0-未投递,1-已投递)")
	private Integer deliveryFlag;
}
