package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yslong
 * @Date: 2022/3/14 16:47
 * @Description: 统一返回结果类
 */
@Data
@Builder
@ApiModel("统一返回结果集")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    /**
     * 操作成功
     *
     * @param data 返回内容
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(true, ResultCode.SUCCESS, Constant.RESULT_SUCCESS, data);
    }

    /**
     * 操作成功
     *
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<>(true, ResultCode.SUCCESS, Constant.RESULT_SUCCESS, null);
    }

    /**
     * 操作失败
     * @param data 内容
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(T data) {
        return new Result<T>(false, ResultCode.ERROR, Constant.RESULT_ERROR, data);
    }

    public static  <T> Result<T> error(T data, Integer code) {
        Result<T> res = new  Result<T>();
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

    public static <T> Result<T> error() {
        return new Result<T>(false,ResultCode.ERROR,Constant.RESULT_ERROR,null);
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
