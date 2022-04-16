package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yslong
 * @Date: 2022/3/14 16:47
 * @Description: 统一返回结果类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("统一返回结果集")
public class Result implements Serializable {

    @ApiModelProperty(value = "是否成功")
    Boolean success;

    @ApiModelProperty(value = "返回码")
    Integer code;

    @ApiModelProperty(value = "返回消息")
    String message;

    @ApiModelProperty(value = "返回数据")
    Object data;


    public static Result success(Object data) {
        Result res = new Result();
        res.setSuccess(true);
        res.setData(data);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage(Constant.RESULT_SUCCESS);
        return res;
    }

    public static Result success() {
        Result res = new Result();
        res.setSuccess(true);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage(Constant.RESULT_SUCCESS);
        return res;
    }

    public static Result error(Object data) {
        Result res = new Result();
        res.setSuccess(false);
        res.setData(data);
        res.setCode(ResultCode.ERROR);
        res.setMessage(Constant.RESULT_ERROR);
        return res;
    }

    public static Result error(Object data, Integer code) {
        Result res = new Result();
        res.setSuccess(false);
        res.setData(data);
        res.setCode(code);
        if (ResultCode.AUTHORIZE.equals(code)) {
            res.setMessage(Constant.AUTHORITY_ERROR);
        } else {
            res.setMessage(Constant.RESULT_ERROR);
        }
        return res;
    }

    public static Result error() {
        Result res = new Result();
        res.setSuccess(false);
        res.setCode(ResultCode.ERROR);
        res.setMessage(Constant.RESULT_ERROR);
        return res;
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
