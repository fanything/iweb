package com.iweb.context.exception;


import com.iweb.common.util.RestResultUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by hsk on 2016/3/3.
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Object resolveAndWriteException(Exception ex){
        if(ex instanceof HttpRequestMethodNotSupportedException){
            return RestResultUtil.error("不支持请求方法类型");
        }

        if(ex instanceof MethodArgumentTypeMismatchException){
            return RestResultUtil.error("参数类型不匹配");
        }

        if(ex instanceof MissingServletRequestParameterException){
            return RestResultUtil.error("缺少参数");
        }

        if(ex instanceof HttpMediaTypeException){
            return RestResultUtil.error("请求体协议不符合");
        }
        return RestResultUtil.toMap(ex);
    }

}

