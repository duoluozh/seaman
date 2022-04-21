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
 * <p>简历实体类</p>
 * @author yslong
 * @date 2022-04-12 14:10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("简历")
@TableName(value = "resume")
@Table(tableName = "resume",keyFields = "id")
public class Resume implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */

	@Id
	@ApiModelProperty(value = "主键ID")
	@Column(name = "id")
	private Long id;

	/**
	 * 称谓
	 */
	@ApiModelProperty(value = "称谓")
	@Column(name = "appellation")
	private String appellation;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	@Column(name = "sex")
	private String sex;

	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	@Column(name = "age")
	private Integer age;

	/**
	 * 民族
	 */
	@ApiModelProperty(value = "民族")
	@Column(name = "nation")
	private String nation;

	/**
	 * 身高
	 */
	@ApiModelProperty(value = "身高")
	@Column(name = "height")
	private Integer height;

	/**
	 * 政治面貌
	 */
	@ApiModelProperty(value = "政治面貌")
	@Column(name = "political_outlook")
	private String politicalOutlook;

	/**
	 * 籍贯
	 */
	@ApiModelProperty(value = "籍贯")
	@Column(name = "native_place")
	private String nativePlace;

	/**
	 * 婚姻状况
	 */
	@ApiModelProperty(value = "婚姻状况")
	@Column(name = "marital_status")
	private String maritalStatus;

	/**
	 * 现居住地
	 */
	@ApiModelProperty(value = "现居住地")
	@Column(name = "current_residence")
	private String currentResidence;

	/**
	 * 学历
	 */
	@ApiModelProperty(value = "学历")
	@Column(name = "education")
	private String education;

	/**
	 * 航海经验
	 */
	@ApiModelProperty(value = "航海经验")
	@Column(name = "experience_sailing")
	private String experienceSailing;

	/**
	 * 毕业学校
	 */
	@ApiModelProperty(value = "毕业学校")
	@Column(name = "graduation_school")
	private String graduationSchool;

	/**
	 * 证书等级
	 */
	@ApiModelProperty(value = "证书等级")
	@Column(name = "certificate_level")
	private String certificateLevel;

	/**
	 * 毕业时间
	 */
	@ApiModelProperty(value = "毕业时间")
	@Column(name = "graduation_time")
	private LocalDateTime graduationTime;

	/**
	 * 原任职务
	 */
	@ApiModelProperty(value = "原任职务")
	@Column(name = "original_position")
	private String originalPosition;

	/**
	 * 专业
	 */
	@ApiModelProperty(value = "专业")
	@Column(name = "major")
	private String major;

	/**
	 * 特殊技能
	 */
	@ApiModelProperty(value = "特殊技能")
	@Column(name = "technical_skill")
	private String technicalSkill;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 应聘职位
	 */
	@ApiModelProperty(value = "应聘职位")
	@Column(name = "job_application")
	private String jobApplication;

	/**
	 * 要求月薪
	 */
	@ApiModelProperty(value = "要求月薪")
	@Column(name = "monthly_salary")
	private String monthlySalary;

	/**
	 * 船舶要求
	 */
	@ApiModelProperty(value = "船舶要求")
	@Column(name = "ship_requirements")
	private String shipRequirements;

	/**
	 * 航线要求
	 */
	@ApiModelProperty(value = "航线要求")
	@Column(name = "route_requirements")
	private String routeRequirements;

	/**
	 * 上船地点
	 */
	@ApiModelProperty(value = "上船地点")
	@Column(name = "boarding_place")
	private String boardingPlace;

	/**
	 * 要求总吨
	 */
	@ApiModelProperty(value = "要求总吨")
	@Column(name = "required_gross")
	private Long requiredGross;

	/**
	 * 上船地点
	 */
	@ApiModelProperty(value = "用户状态(0-在职不考虑机会，1-在职考虑机会，2-离职状态)")
	@Column(name = "user_status")
	private String userStatus;

	/**
	 * 要求总吨
	 */
	@ApiModelProperty(value = "更新时间")
	@Column(name = "update_time")
	private LocalDateTime updateTime;

}
