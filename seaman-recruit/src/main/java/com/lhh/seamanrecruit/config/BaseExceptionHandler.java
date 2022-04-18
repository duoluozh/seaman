package com.lhh.seamanrecruit.config;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Author: yslong
 * @Date: 2022/3/14 15:55
 * @Description: 统一异常处理类
 */

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        if (Constant.TOKEN_ISNULL.equals(e.getMessage())) {
            return Result.error(Constant.LOGIN_FIRST, ResultCode.AUTHORIZE);
        }
        if (Constant.USER_ISNULL.equals(e.getMessage())) {
            return Result.error(Constant.USERNAME_NOT_EXIST_LOGIN, ResultCode.AUTHORIZE);
        }
        if (Constant.ERROR_TOKEN.equals(e.getMessage())) {
            return Result.error(Constant.INVALID_LOGIN, ResultCode.AUTHORIZE);
        }
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

}
