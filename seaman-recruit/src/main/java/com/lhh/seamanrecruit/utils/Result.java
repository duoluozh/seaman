package com.lhh.seamanrecruit.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Author: yslong
 * @Date: 2022/3/14 16:47
 * @Description: 统一返回结果类
 */
@Data
public class Result {

    @ApiModelProperty(value = "是否成功")
    Boolean success;

    @ApiModelProperty(value = "返回码")
    Integer code;

    @ApiModelProperty(value = "返回消息")
    String message;

    @ApiModelProperty(value = "返回数据")
    Object data;

}
