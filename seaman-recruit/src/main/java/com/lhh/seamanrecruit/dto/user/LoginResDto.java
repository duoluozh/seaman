package com.lhh.seamanrecruit.dto.user;

import com.lhh.seamanrecruit.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: yslong
 * @Date: 2022/4/9 11:16
 * @Description: 用户登录出参
 */
@Data
@ApiModel("用户登录入参")
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;


    /**
     * 用户类型(0-船员,1-企业用户,2-超管用户)
     */
    @ApiModelProperty(value = "用户类型(0-船员,1-企业用户,2-超管用户)")
    private Integer userType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;
}
