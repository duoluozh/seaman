package com.lhh.seamanrecruit.utils;

import lombok.Data;
import java.util.Map;

/**
 * @Author: yslong
 * @Date: 2022/3/14 14:27
 * @Description: 返回结果参数封装
 */
@Data
public class ResultUtils extends Result {

    public static ResultUtils ok(){
        ResultUtils res = new ResultUtils();
        res.setSuccess(true);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage("操作成功");
        return res;
    }

    public static ResultUtils error(){
        ResultUtils res = new ResultUtils();
        res.setSuccess(false);
        res.setCode(ResultCode.ERROR);
        res.setMessage("操作失败");
        return res;
    }

    public ResultUtils success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultUtils message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultUtils code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultUtils data( Object value){
        setData(value);
        return this;
    }

    public ResultUtils data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    @Override
    public String toString() {
        return "ResultUtils{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
