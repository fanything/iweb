package com.iweb.context.exception;

import com.iweb.common.util.RestResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:FanMingxin
 * @Date: 2018-05-31 下午 09:20
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    public Object error(HttpServletResponse response, HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        log.error("REQUEST-STATUS:"+status.value() + ";REQUEST-URL:" + getRequestURI(request));
        logExceptionInfo(request);
        return RestResultUtil.error(status.value(),getErrorMessage(request,status));
    }

    protected void logExceptionInfo(HttpServletRequest request){
        Object exception = request.getAttribute("org.springframework.web.servlet.DispatcherServlet.EXCEPTION");
        if(exception == null){
            return;
        }
        log.error(exception.toString());
    }

    protected String getRequestURI(HttpServletRequest request){
        Object uri = request.getAttribute("javax.servlet.error.request_uri");
        if(uri == null){
            return "";
        }
        return uri.toString();
    }

    protected String getErrorMessage(HttpServletRequest request,HttpStatus status){
        Object message = request.getAttribute("javax.servlet.error.message");
        if(message == null || "".equals(message.toString())){
            return status.getReasonPhrase();
        }
        return message.toString();
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}