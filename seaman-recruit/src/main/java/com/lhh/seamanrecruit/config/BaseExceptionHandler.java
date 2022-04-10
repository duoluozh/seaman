package com.lhh.seamanrecruit.config;

import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: yslong
 * @Date: 2022/3/14 15:55
 * @Description: 统一异常处理类
 */

@ControllerAdvice
@Slf4j
public class BaseExceptionHandler{

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        if ("toke-isNull".equals(e.getMessage())){
            return ResultUtils.error("请先进行登录！");
        }
        if ("user-isNull".equals(e.getMessage())){
            return ResultUtils.error("用户不存在请重新登陆！");
        }
        if ("token-error".equals(e.getMessage())){
            return ResultUtils.error("无效token！");
        }
        return ResultUtils.error("服务器内部异常！");
    }

}
