/**
 * JsonReturnAspect.java
 * com.we.core.web.aop
 * Copyright (c) 2017, 北京聚智未来科技有限公司版权所有.
*/

package com.iweb.context.aop;

import com.iweb.common.util.RestResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @author:FanMingxin
 * @Date: 2018-05-09 下午 02:28
 */
@Component
@Aspect
@Order(2)
public class RestCodeAspect {

	@Around(value = "@annotation(com.iweb.context.annotation.RestCode)")
	@Order(1)
	public Object warp(final ProceedingJoinPoint pjp) throws Throwable {
		Object list = pjp.proceed();

		if (isReturnVoid(pjp)) {
			return RestResultUtil.success("成功");
		}

		return RestResultUtil.data(list);
	}

	private boolean isReturnVoid(ProceedingJoinPoint pjp) {
		Method method = getMethod(pjp);
		Class<?> returnType = method.getReturnType();
		return "void".equals(returnType.getName());
	}

	public static Method getMethod(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		return methodSignature.getMethod();
	}
}