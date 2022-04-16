package com.lhh.seamanrecruit.entity;

import java.time.LocalDate;

import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

/**
 * <p>公司实体类</p>
 * @author yslong
 * @date 2022-04-12 14:10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公司")
@TableName(value = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@ApiModelProperty(value = "主键id")
	private Long id;

	/**
	 * 公司名称
	 */
	@ApiModelProperty(value = "公司名称")
	private String companyName;

	/**
	 * 社会信用代码
	 */
	@ApiModelProperty(value = "社会信用代码")
	private String socialCreditCode;

	/**
	 * 法定代表人
	 */
	@ApiModelProperty(value = "法定代表人")
	private String representative;

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
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱")
	private String email;

	/**
	 * 地址
	 */
	@ApiModelProperty(value = "地址")
	private String address;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;

}
