package com.lhh.seamanrecruit.dto.resume;

import com.lhh.seamanrecruit.dto.BaseQueryDto;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @Author: y_slong
 * @Date: 2022/05/01 21:57
 * @Description:
 */
public class ResumeDto extends BaseQueryDto {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */

    @Id
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 称谓
     */
    @ApiModelProperty(value = "称谓")
    private String appellation;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private Integer height;

    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌")
    private String politicalOutlook;

    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    /**
     * 婚姻状况
     */
    @ApiModelProperty(value = "婚姻状况")
    private String maritalStatus;

    /**
     * 现居住地
     */
    @ApiModelProperty(value = "现居住地")
    private String currentResidence;

    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    private String education;

    /**
     * 航海经验
     */
    @ApiModelProperty(value = "航海经验")
    private String experienceSailing;

    /**
     * 毕业学校
     */
    @ApiModelProperty(value = "毕业学校")
    private String graduationSchool;

    /**
     * 证书等级
     */
    @ApiModelProperty(value = "证书等级")
    private String certificateLevel;

    /**
     * 毕业时间
     */
    @ApiModelProperty(value = "毕业时间")
    private LocalDateTime graduationTime;

    /**
     * 原任职务
     */
    @ApiModelProperty(value = "原任职务")
    private String originalPosition;

    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    private String major;

    /**
     * 特殊技能
     */
    @ApiModelProperty(value = "特殊技能")
    private String technicalSkill;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 应聘职位
     */
    @ApiModelProperty(value = "应聘职位")
    private String jobApplication;

    /**
     * 要求月薪
     */
    @ApiModelProperty(value = "要求月薪")
    private String monthlySalary;

    /**
     * 船舶要求
     */
    @ApiModelProperty(value = "船舶要求")
    private String shipRequirements;

    /**
     * 航线要求
     */
    @ApiModelProperty(value = "航线要求")
    private String routeRequirements;

    /**
     * 上船地点
     */
    @ApiModelProperty(value = "上船地点")
    private String boardingPlace;

    /**
     * 要求总吨
     */
    @ApiModelProperty(value = "要求总吨")
    private Long requiredGross;

    /**
     * 上船地点
     */
    @ApiModelProperty(value = "用户状态(0-在职不考虑机会，1-在职考虑机会，2-离职状态)")
    private String userStatus;

    /**
     * 要求总吨
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
