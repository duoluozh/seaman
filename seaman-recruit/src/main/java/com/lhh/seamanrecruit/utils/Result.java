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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
