package com.iweb.context.exception;

import com.iweb.common.util.RestResultUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:FanMingxin
 * @Date: 2018-05-31 下午 09:20
 * @Description:
 */
@RestController
public class GlobalExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public Object error(HttpServletResponse response, HttpServletRequest req) {
        if(response.getStatus()== 404){
            return RestResultUtil.error(404,"找不到要访问的资源");
        }

        //TODO  待补充其他一些未捕获的错误
        return RestResultUtil.error(500,"系统内部错误");
    }
}