package com.iweb.context.exception;


import com.iweb.common.util.ExceptionUtil;
import com.iweb.common.util.RestResultUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by hsk on 2016/3/3.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Object resolveAndWriteException(Exception ex){
        String exMsg = getExMessage(ex);
        log.error(exMsg,ex);

        return RestResultUtil.error(exMsg);
    }

    /**
     * 获取异常描述信息
     *
     * @param ex
     * @return java.lang.String
     * @throws
     */
    private String getExMessage(Exception ex){

        if(ex instanceof HttpRequestMethodNotSupportedException){
            return "不支持请求方法类型";
        }

        if(ex instanceof MethodArgumentTypeMismatchException){
            return "参数类型不匹配";
        }

        if(ex instanceof MissingServletRequestParameterException){
            return "缺少请求参数";
        }

        if(ex instanceof HttpMediaTypeException){
            return "请求体协议不符合";
        }

        return ExceptionUtil.getSimpleMessage(ex);
    }
}

