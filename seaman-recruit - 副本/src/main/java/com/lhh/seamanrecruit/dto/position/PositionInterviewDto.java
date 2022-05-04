package com.lhh.seamanrecruit.dto.position;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author zhh
 * @date 2022/5/3 12:51
 * @description
 */
@Data
@ApiModel("面试邀请接口入参实体类")
@AllArgsConstructor
@NoArgsConstructor
public class PositionInterviewDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "简历用户id")
    private Long userId;

    /**
     * 职位Id
     */
    @ApiModelProperty(value = "职位id")
    private Long positionId;

    /**
     * 企业用户id
     */
    @ApiModelProperty(value = "企业用户id")
    private Long companyUserId;
}
