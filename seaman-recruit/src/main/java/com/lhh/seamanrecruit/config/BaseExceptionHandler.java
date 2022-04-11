package com.lhh.seamanrecruit.config;

import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.Result;
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
        if ("token-isNull".equals(e.getMessage())){
            return Result.error("请先进行登录！",401);
        }
        if ("user-isNull".equals(e.getMessage())){
            return Result.error("用户不存在，请重新登录！",401);
        }
        if ("error-token".equals(e.getMessage())){
            return Result.error("无效登录，请重新登录！",401);
        }
        return Result.error(e.getMessage());
    }

}
