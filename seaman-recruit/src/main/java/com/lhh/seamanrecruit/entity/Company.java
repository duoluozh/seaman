package com.lhh.seamanrecruit.entity;

import java.time.LocalDate;

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
 * <p>公司实体类</p>
 * @author yslong
 * @date 2022-04-12 14:10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公司")
@TableName(value = "company")
@Table(tableName = "company",keyFields = "id")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@ApiModelProperty(value = "主键id")
	@Column(name = "id")
	private Long id;

	/**
	 * 公司名称
	 */
	@ApiModelProperty(value = "公司名称")
	@Column(name = "company_name")
	private String companyName;

	/**
	 * 社会信用代码
	 */
	@ApiModelProperty(value = "社会信用代码")
	@Column(name = "social_credit_code")
	private String socialCreditCode;

	/**
	 * 法定代表人
	 */
	@ApiModelProperty(value = "法定代表人")
	@Column(name = "representative")
	private String representative;

	/**
	 * 公司性质
	 */
	@ApiModelProperty(value = "公司性质")
	@Column(name = "company_type")
	private String companyType;

	/**
	 * 成立年份
	 */
	@ApiModelProperty(value = "成立年份")
	@Column(name = "year")
	private LocalDate year;

	/**
	 * 注册资金
	 */
	@ApiModelProperty(value = "注册资金")
	@Column(name = "capital")
	private Long capital;

	/**
	 * 员工人数
	 */
	@ApiModelProperty(value = "员工人数")
	@Column(name = "employees_number")
	private String employeesNumber;

	/**
	 * 公司网址
	 */
	@ApiModelProperty(value = "公司网址")
	@Column(name = "website")
	private String website;

	/**
	 * 公司简介
	 */
	@ApiModelProperty(value = "公司简介")
	@Column(name = "company_desc")
	private String companyDesc;

	/**
	 * 联系人
	 */
	@ApiModelProperty(value = "联系人")
	@Column(name = "contacts_name")
	private String contactsName;

	/**
	 * 固定电话
	 */
	@ApiModelProperty(value = "固定电话")
	@Column(name = "phone")
	private String phone;

	/**
	 * 传真
	 */
	@ApiModelProperty(value = "传真")
	@Column(name = "fax")
	private String fax;

	/**
	 * 联系手机
	 */
	@ApiModelProperty(value = "联系手机")
	@Column(name = "contacts_phone")
	private String contactsPhone;

	/**
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱")
	@Column(name = "email")
	private String email;

	/**
	 * 地址
	 */
	@ApiModelProperty(value = "地址")
	@Column(name = "address")
	private String address;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	@Column(name = "user_id")
	private Long userId;

}
