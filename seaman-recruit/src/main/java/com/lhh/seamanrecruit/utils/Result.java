package com.lhh.seamanrecruit.utils;

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
        res.setMessage("操作成功");
        return res;
    }

    public static Result success() {
        Result res = new Result();
        res.setSuccess(true);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage("操作成功");
        return res;
    }

    public static Result error(Object data) {
        Result res = new Result();
        res.setSuccess(false);
        res.setData(data);
        res.setCode(ResultCode.ERROR);
        res.setMessage("操作失败");
        return res;
    }

    public static Result error(Object data, Integer code) {
        Result res = new Result();
        res.setSuccess(false);
        res.setData(data);
        res.setCode(code);
        if (ResultCode.AUTHORIZE.equals(code)) {
            res.setMessage("获取授权失败");
        } else {
            res.setMessage("操作失败");
        }
        return res;
    }

    public static Result error() {
        Result res = new Result();
        res.setSuccess(false);
        res.setCode(ResultCode.ERROR);
        res.setMessage("操作失败");
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
