package com.iweb.common.exception.impl;

import com.iweb.common.exception.IBusinessException;
/**
 * @author:FanMingxin
 * @Date: 2018-06-01 下午 06:54
 * @Description:
 */
public class BusinessException extends RuntimeException implements IBusinessException {
    private static final long serialVersionUID = 4841002170027340733L;

    public BusinessException() {
        super();
    }

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }
}
