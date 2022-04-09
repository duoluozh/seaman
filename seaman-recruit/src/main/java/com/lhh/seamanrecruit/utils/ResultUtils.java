package com.lhh.seamanrecruit.utils;

import lombok.Data;

/**
 * @Author: yslong
 * @Date: 2022/3/14 14:27
 * @Description: 返回结果参数封装
 */
@Data
public class ResultUtils extends Result {

    public static ResultUtils success(Object data){
        ResultUtils res = new ResultUtils();
        res.setSuccess(true);
        res.setData(data);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage("操作成功");
        return res;
    }

    public static ResultUtils success(){
        ResultUtils res = new ResultUtils();
        res.setSuccess(true);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage("操作成功");
        return res;
    }

    public static ResultUtils error(Object data){
        ResultUtils res = new ResultUtils();
        res.setSuccess(false);
        res.setData(data);
        res.setCode(ResultCode.ERROR);
        res.setMessage("操作失败");
        return res;
    }

    public static ResultUtils error(){
        ResultUtils res = new ResultUtils();
        res.setSuccess(false);
        res.setCode(ResultCode.ERROR);
        res.setMessage("操作失败");
        return res;
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
